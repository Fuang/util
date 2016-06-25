/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util;

import com.huangpf.util.exception.BaseExceptionMsg;
import com.huangpf.util.exception.Thrower;

/**
 * 异常类测试
 *
 * @author: Huangpf  Date: 2016/6/15 Time: 15:20.
 */
public class ExceptionMsgTest {

    public static void main(String[] args){
        //System.out.println("ytfhg");
        Thrower.throwException(BaseExceptionMsg.NULLPOINTER_EXCEPTIOIN);
    }
}
