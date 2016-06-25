/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.exception;

/**
 * 设置抛异常的内容，该类为基础的异常信息，其他异常信息可参照此类写对应的异常信息类
 *
 * @author: Huangpf  Date: 2016/4/25 Time: 22:20.
 */
public enum BaseExceptionMsg implements IExceptionMsg {
    NULLPOINTER_EXCEPTIOIN("空指针异常", 10000000),
    ;

    private String message = null;
    private ExceptionLevel level = null;
    private long errorCode;

    BaseExceptionMsg(String message, long errorCode){
        this.message = message;
        this.errorCode = errorCode;
        this.level = ExceptionLevel.ERROR;
    }

    /**
     * 返回异常编码
     * @return
     */
    public String getCode() {
        return toString();
    }

    /**
     * 返回异常级别
     * @return
     */
    public ExceptionLevel getLevel() {
        return level;
    }

    /**
     * 返回异常信息
     * @return
     */
    public String getMessage() {
        return message;
    }
}
