/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工程统一公共异常类，Thrower抛出的异常，合成框架异常的信息，
 *
 * @author: Huangpf  Date: 2016/4/23 Time: 16:57.
 */
public class BaseException extends RuntimeException {
    private static final Pattern PARAM_PATTERN = Pattern.compile("\\{\\s*\\}");

    private String serviceCode = "";//APP服务编码
    private String processName = "";//线程名
    private String date = "";

    private String exceptionCode = "";//异常编码（供前台显示使用）
    private String exceptionMessage = "";//异常信息（供前台显示使用）
    private String exceptionStack = "";

    private BaseException() {
    }


    public BaseException(String exceptionCode, String exceptionMessage) {
        this(exceptionCode, exceptionMessage, null, null);
    }


    public BaseException(String exceptionCode, String exceptionMessage, Object[] exceptionParams) {
        this(exceptionCode, exceptionMessage, exceptionParams, null);
    }


    public BaseException(String exceptionCode, String exceptionMessage, Throwable cause) {
        this(exceptionCode, exceptionMessage, null, cause);
    }

    /**
     * 创建异常类
     * @param exceptionCode 异常编码
     * @param exceptionMessage 异常信息
     * @param exceptionParams 异常信息参数
     * @param cause 异常类
     */
    public BaseException(String exceptionCode, String exceptionMessage, Object[] exceptionParams, Throwable cause) {
        super(exceptionCode);
        String message = constructExceptionMessage(exceptionMessage, exceptionParams);
        this.exceptionMessage = this.setMessage(message);
        this.exceptionCode = exceptionCode;
    }

    /**
     * 设置异常类公共信息
     * @param message
     * @return
     */
    private String setMessage(String message) {
        //TODO 设置框架统一异常信息（可用APP服务名之类）
        return message;
    }

    /**
     * 异常信息参数匹配
     * @param message
     * @param params
     * @return
     */
    private String constructExceptionMessage(String message, Object[] params) {
        if (params != null) {
            Matcher matcher = PARAM_PATTERN.matcher(message);
            StringBuffer sb = new StringBuffer();
            int paramsLength = params.length;
            int index = 0;
            while ((matcher.find()) && (index < paramsLength)) {
                Object value = params[(index++)];
                if ((value != null) && ((value instanceof Class))) {
                    value = ((Class) value).getName();
                }

                String text = "";
                if (value != null) {
                    text = value.toString();
                    //if (StringUtils.length(text) > 256) {
                    //    text = StringUtils.substring(text, 0, 256);
                    //}
                }
                matcher.appendReplacement(sb, text);
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
        return message;
    }
}
