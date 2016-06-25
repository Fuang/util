/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

/**
 * 通过实现Runnable方法
 *
 * @author: Huangpf  Date: 2016/6/7 Time: 11:34.
 */
public class ThreadA implements Runnable {

    /**
     * 实现Runnable的run方法
     */
    public void run() {
        for (int i=0; i<100; i++){
            System.out.println("ThreadA:" + i);
        }

    }
}
