/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

/**
 * 2.继承Thread类，一般重写run方法
 *
 * @author: Huangpf  Date: 2016/6/7 Time: 11:35.
 */
public class ThreadB extends Thread {

    /**
     * 重写run方法
     */
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("ThreadB:" + i);
        }

    }
}
