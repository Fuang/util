/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

/**
 * 关键字synchronized的用法
 *
 * @author: Huangpf  Date: 2016/6/7 Time: 18:00.
 */
public class SyncThread implements Runnable {

    private static int count = 0;

    /**
     * 修饰代码块（作用范围单对象）
     */
    public void run1() {
        synchronized (this){
            for (int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 修饰方法（作用范围单对象）
     */
    public synchronized void run2() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 修饰静态方法（作用范围该类所有对象）
     */
    public synchronized static void method(){
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run3(){
        method();
    }

    /**
     * 修饰整个类（作用范围该类所有对象）
     */
    public void run(){
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
