/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

/**
 * 线程、多线程编程、以及线程周边测试类
 *
 * @author: Huangpf  Date: 2016/6/4 Time: 11:36.
 */
public class TheadTest {

    /**
     * 创建Thread对象测试
     * @param args
     */
    public static void main1(String[] args){
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new ThreadB();

        threadA.start();
        threadB.start();
    }

    /**
     * 关键字synchrosized的使用测试
     * @param args
     */
    public static void main2(String[] args){
        //SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "Thread1");
        Thread thread2 = new Thread(new SyncThread(), "Thread2");

        thread1.start();
        thread2.start();
    }

    /**
     * 线程wait、notify、notifyall测试
     * @param args
     */
    public static void main(String[] args){

        Message msg = new Message("notifyTest");

        //起两个线程，并且进入wait状态
        Thread thread1 = new Thread(new Waiter(msg), "Waiter1");
        Thread thread2 = new Thread(new Waiter(msg), "Waiter2");
        thread1.start();
        thread2.start();

        //notify
        Thread notifier = new Thread(new Notifier(msg), "Notifier");
        notifier.start();
    }
}
