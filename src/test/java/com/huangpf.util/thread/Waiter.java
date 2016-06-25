/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;

/**
 * 调用wait方法的线程
 *
 * @author: Huangpf  Date: 2016/6/8 Time: 15:05.
 */
public class Waiter implements Runnable {
    private static Logger log = RootLogger.getRootLogger();

    private Message msg;

    public Waiter(Message msg){
        this.msg = msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (msg){
            log.debug(name + "waiting to get notified at time:" + System.currentTimeMillis());
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug(name + "waiter thread got notified at time:" + System.currentTimeMillis());
        }
    }
}
