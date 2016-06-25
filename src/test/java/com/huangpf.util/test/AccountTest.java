/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.test;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/4 Time: 15:24.
 */
public class AccountTest {
    private static int NUM_OF_THREAD = 10000;
    static Thread[] threads = new Thread[NUM_OF_THREAD];

    public static void main(String[] args){
        final Account acc = new Account("John", 1000.0f);
        for (int i = 0; i< NUM_OF_THREAD; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    acc.deposit(100.0f);
                    acc.withdraw(100.0f);
                }
            });
            threads[i].start();
        }

        for (int i=0; i<NUM_OF_THREAD; i++){
            try {
                threads[i].join(); //等待所有线程运行结束
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
    }
}
