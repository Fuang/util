/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/15 Time: 22:25.
 */
public class Test {
    public static Logger log = Logger.getRootLogger();

    public static void main(String[] args){
        log.debug(System.getenv());
        log.debug(System.getProperties());
        log.debug(System.getSecurityManager());
        AtomicInteger poolNumber = new AtomicInteger(1);
        log.debug(poolNumber);

        //OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), charsetName);
    }
}
