/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.exception;

import org.apache.log4j.Logger;

/**
 * 封装异常的抛出，设置统一的业务异常信息
 * @author: Huangpf  Date: 2016/4/23 Time: 11:21.
 */
public class Thrower {
    private static Logger log = Logger.getLogger(Thrower.class);

    public static void throwException(IExceptionMsg e) throws RuntimeException {
        throwException(e, (Throwable) null);
    }

    public static void throwException(IExceptionMsg e, Object... param) throws RuntimeException {
        throwException(e, null, param);
    }

    public static void throwException(IExceptionMsg e, Throwable exp, Object... param) throws RuntimeException {
        String msg = String.format(e.getMessage(), param);
        throwException(e.getCode(), e.getLevel(), msg, exp);
    }

    private static void throwException(String code, IExceptionMsg.ExceptionLevel level, String msg, Throwable e) throws RuntimeException {
        if (e != null) {//若异常不为空，显示异常信息
            msg = msg + e.getMessage();
        }

        String message = code + ":" + msg;
        if (level == IExceptionMsg.ExceptionLevel.WARN) {
            log.warn(message);
        } else if (level == IExceptionMsg.ExceptionLevel.ERROR) {
            log.error(message, e);
        }

        BaseException ex = new BaseException(code, message);

        throw ex;
    }

}
