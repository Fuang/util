package com.huangpf.util.data.impl;

import com.huangpf.util.data.IData;
import com.huangpf.util.data.IDataset;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.*;

public class DatasetList extends ArrayList<Object> implements IDataset {
    private static final long serialVersionUID = 8302984775243577040L;

    /**
     * 初始化
     */
    public DatasetList() {
        super(20);
    }

    public DatasetList(int size) {
        super(size);
    }

    public DatasetList(IData data) {
        super(20);
        add(data);
    }

    public DatasetList(IData[] datas) {
        super(20);
        for (IData data : datas) {
            add(data);
        }
    }

    public DatasetList(IDataset list) {
        super(20);
        addAll(list);
    }

    public DatasetList(String jsonArray) {
        super(20);

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Map.class);//设置解析为List<Map<String,Object>>，list里可为其他对象
        try {
            list = objectMapper.readValue(jsonArray, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addAll(list);
    }

    public String[] getNames() {
        return size() > 0 ? ((IData) get(0)).getNames() : null;
    }

    @Override
    public Object get(int index) {
        return super.get(index);
    }

    public Object get(int index, String name) {
        Object data = get(index);
        if (null == data) {
            return null;
        }
        if ((data instanceof Map<?, ?>)) {
            IData map = new DataMap();
            map.putAll((HashMap<String, Object>) data);
            return map.get(name);
        }

        return null;
    }

    public Object get(int index, String name, Object def) {
        Object value = get(index, name);
        return value == null ? def : value;
    }

    public IData getData(int index) {
        Object value = get(index);
        if (value == null)
            return null;
        if ((value instanceof String))
            return new DataMap((String) value);

        return (IData) value;
    }

    public IDataset getDataset(int index) {
        Object value = get(index);
        if (value == null) {
            return null;
        }
        if ((value instanceof String)){
            return new DatasetList((String) value);
        }
        return (IDataset) value;
    }

    public IData first() {
        return size() > 0 ? (IData) get(0) : null;
    }

    public IData toData() {
        IData data = new DataMap();

        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            IData element = (IData) it.next();
            Iterator<String> iterator = element.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (data.containsKey(key)) {
                    IDataset list = (IDataset) data.get(key);
                    list.add(element.get(key));
                } else {
                    IDataset list = new DatasetList();
                    list.add(element.get(key));
                    data.put(key, list);
                }
            }
        }

        return data;
    }

}
