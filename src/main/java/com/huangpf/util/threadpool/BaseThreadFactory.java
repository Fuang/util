/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂类，可以设置线程名、线程group……，没有特殊设置直接使用DefaultThreadFactory
 *
 * @author: Huangpf  Date: 2016/6/15 Time: 23:57.
 */
public class BaseThreadFactory implements ThreadFactory {
    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final ThreadGroup group;
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final String namePrefix;

    /**
     * 构造方法
     */
    public BaseThreadFactory(){
        SecurityManager s = System.getSecurityManager();
        this.group = (s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup());

        this.namePrefix = ("pool-" + poolNumber.getAndIncrement() + "-app-");
    }

    /**
     * 实例化一个线程
     * @param r
     * @return
     */
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}
