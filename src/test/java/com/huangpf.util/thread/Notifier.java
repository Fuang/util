/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;

/**
 * 调用notify的线程
 *
 * @author: Huangpf  Date: 2016/6/8 Time: 15:12.
 */
public class Notifier implements Runnable {
    private static Logger log = RootLogger.getRootLogger();

    private Message msg;

    public Notifier(Message msg){
        this.msg = msg;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        log.debug(name + "start");

        try {
            Thread.sleep(1000);
            synchronized (msg){
                msg.notify();//唤醒一个线程
                //msg.notifyAll();//唤醒所有线程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
