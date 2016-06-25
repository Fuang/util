/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.threadpool;

import java.util.concurrent.Callable;

/**
 * 自定义Callable实现类，线程池用submit方法执行时，会调用Callable实现类的call方法，并且返回值
 *
 * @author: Huangpf  Date: 2016/6/16 Time: 0:52.
 */
public class BaseCallable<T> implements Callable<T> {

    public T call() throws Exception {
        return null;
    }
}
