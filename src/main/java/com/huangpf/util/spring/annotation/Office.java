/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.spring.annotation;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/23 Time: 9:27.
 */
public class Office {

    private String officeNo ="001";

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public String getOfficeNo() {

        return officeNo;
    }

    @Override
    public String toString() {
        return "officeNo:" + officeNo;
    }
}
