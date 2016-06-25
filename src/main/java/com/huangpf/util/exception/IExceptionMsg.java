/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.exception;

/**
 * 统一异常处理接口
 *
 * @author: Huangpf  Date: 2016/4/23 Time: 11:38.
 */
public interface IExceptionMsg {
    enum ExceptionLevel {
        INFO, WARN, ERROR, FAIL
    }

    String getCode();

    ExceptionLevel getLevel();

    String getMessage();
}
