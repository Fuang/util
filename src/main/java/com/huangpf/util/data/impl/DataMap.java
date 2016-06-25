package com.huangpf.util.data.impl;

import com.huangpf.util.data.IData;
import com.huangpf.util.data.IDataset;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataMap extends HashMap<String, Object> implements IData {
    private static final long serialVersionUID = 5728540280422795959L;

    public DataMap() {
    }

    public DataMap(int size) {
        super(size);
    }

    public DataMap(Map<String, Object> map) {
        super(map);
    }

    /**
     * 根据json格式的字符串生成map
     * @param jsonObject
     */
    public DataMap(String jsonObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            putAll(mapper.readValue(jsonObject, Map.class));
        } catch (IOException e) {
            e.printStackTrace();//TODO
        }
    }

    public Object get(String key) {
        Object value = super.get(key);
        if (null == value)
            return null;
        return value;
    }

    public String[] getNames() {
        String[] names = new String[size()];
        Iterator<String> keys = keySet().iterator();
        int index = 0;
        while (keys.hasNext()) {
            names[index] = (keys.next());
            index++;
        }
        return names;
    }

    public boolean isNoN(String name) {
        return (name == null) || (!containsKey(name));
    }

    public String getString(String name) {
        Object value = get(name);
        if (value == null)
            return null;
        return value.toString();
    }

    public String getString(String name, String defaultValue) {
        String value = getString(name);
        if (value == null)
            return defaultValue;
        return value;
    }

    public boolean getBoolean(String name) {
        return getBoolean(name, false);
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        Object value = get(name);
        if (null == value)
            return defaultValue;
        return "true".equalsIgnoreCase(value.toString());
    }

    public double getDouble(String name) {
        return getDouble(name, 0.0D);
    }

    public double getDouble(String name, double defaultValue) {
        Object value = get(name);
        if (value == null) {
            return defaultValue;
        }
        return Double.parseDouble(value.toString());
    }

    public int getInt(String name) {
        return getInt(name, 0);
    }

    public int getInt(String name, int defaultValue) {
        Object value = get(name);
        if (value == null)
            return defaultValue;
        return Integer.parseInt(value.toString());
    }

    public long getLong(String name) {
        return getLong(name, 0L);
    }

    public long getLong(String name, long defaultValue) {
        Object value = get(name);
        if (value == null)
            return defaultValue;
        return Long.parseLong(value.toString());
    }

    public IData getData(String name) {
        Object value = get(name);
        if (value == null) {
            return null;
        }
        if ((value instanceof IData))
            return (IData) value;
        if ((value instanceof String)) {
            return new DataMap((String) value);
        }
        return null;
    }

    public IData getData(String name, IData def) {
        Object value = get(name);
        if (value == null) {
            return def;
        }
        if ((value instanceof IData))
            return (IData) value;
        if ((value instanceof String)) {
            return new DataMap((String) value);
        }
        return def;
    }

    /**
     *
     * @param name
     * @param def
     * @return
     */
    public IDataset getDataset(String name, IDataset def) {
        Object value = get(name);
        if (value == null) {
            return def;
        }
        if ((value instanceof IDataset))
            return (IDataset) value;
        if ((value instanceof String)) {//List格式的json格式字符串
            IDataset ds = new DatasetList((String) value);
            return ds;
        }
        return def;
    }

    public IDataset getDataset(String name) {
        return getDataset(name, null);
    }

    public IData subData(String group) throws Exception {
        return subData(group, false);
    }

    public IData subData(String group, boolean istrim) throws Exception {
        IData element = new DataMap();

        String[] names = getNames();
        String prefix = group + "_";
        for (String name : names) {
            if (name.startsWith(prefix)) {
                element.put(istrim ? name.substring(prefix.length()) : name, get(name));
            }
        }

        return element;
    }

    public String put(String key, String value) {
        return (String) super.put(key, value);
    }

    public IData put(String key, IData value) {
        return (IData) super.put(key, value);
    }

    public IDataset put(String key, IDataset value) {
        return (IDataset) super.put(key, value);
    }

}
