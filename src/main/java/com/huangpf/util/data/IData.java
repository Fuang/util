package com.huangpf.util.data;

import java.io.Serializable;
import java.util.Map;

public interface IData extends Map<String, Object>, Serializable {
    boolean isNoN(String paramString);

    String[] getNames();

    String getString(String paramString);

    String getString(String paramString1, String paramString2);

    boolean getBoolean(String paramString);

    boolean getBoolean(String paramString, boolean paramBoolean);

    int getInt(String paramString);

    int getInt(String paramString, int paramInt);

    long getLong(String paramString);

    long getLong(String paramString, long paramLong);

    double getDouble(String paramString);

    double getDouble(String paramString, double paramDouble);

    com.huangpf.util.data.IDataset getDataset(String paramString);

    com.huangpf.util.data.IDataset getDataset(String paramString, com.huangpf.util.data.IDataset paramIDataset);

    IData getData(String paramString);

    IData getData(String paramString, IData paramIData);

    IData subData(String paramString) throws Exception;

    IData subData(String paramString, boolean paramBoolean) throws Exception;

    String toString();
}
