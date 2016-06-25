package com.huangpf.util.data;

import java.io.Serializable;
import java.util.List;

public interface IDataset extends List<Object>, Serializable {
    int ORDER_ASCEND = 0;// 排序升序

    int ORDER_DESCEND = 1;// 排序降序

    int TYPE_STRING = 2;// 按字符串类型排序

    int TYPE_INTEGER = 3;// 按数字类型排序

    int TYPE_DOUBLE = 4;// 按double类型排序

    int MAX_RECORD = 2000;

    String[] getNames();

    Object get(int paramInt);

    Object get(int paramInt, String paramString);

    Object get(int paramInt, String paramString, Object paramObject);

    IData getData(int paramInt);

    IDataset getDataset(int paramInt);

    IData first();

    IData toData();
}
