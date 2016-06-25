/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.threadpool;

import org.apache.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池使用类
 * 1，用Executors创建线程池分为5种（详情参见源码，一看就能懂），根据具体情况创建一种类型的线程池ExecutorService：
 *     newFixedThreadPool  --固定线程池（线程数量固定）
 *     newWorkStealingPool  --jdk1.8新增（还没看）
 *     newSingleThreadExecutor  --单线程线程池（线程数量=1）
 *     newCachedThreadPool  --无限制线程池（线程数量不够处理任务会新增，空闲（60s）会回收，线程大小根据操作系统能创建的最大线程大小）
 *     ScheduledThreadPoolExecutor  --创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 * 2，调用线程池提供两种调用方法：
 *     1）submit方法支持返回值Future，可自行实现Callable接口（线程任务内容写在call方法里，例如BaseCallable），设置线程任务和返回值
 *     2）execute方法执行Runnable的实现类（线程任务内容写在run方法里），没有返回值。
 *
 * @author: Huangpf  Date: 2016/6/15 Time: 22:18.
 */
public class BaseThreadPool {
    private static final Logger log = Logger.getLogger(BaseThreadPool.class);

    private static final int maximumPoolSize = 5;//线程池线程数，可设置为读取配置文件

    //创建线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(maximumPoolSize);
    //有特殊需求可以自己封装线程工厂类
    //private static ExecutorService executor = Executors.newFixedThreadPool(maximumPoolSize, new BaseThreadFactory());

    /**
     * 线程调用方法,带返回值的线程调用执行callable.call()方法，需写Callable实现类
     */
    public <T> T invokeService(Callable callable){
        Future future = executor.submit(callable);

        return (T) future;//返回数据处理
    }

    /**
     * 执行没有返回参的方法
     * @param runnable
     */
    public void execute(Runnable runnable){
        executor.execute(runnable);
    }
}
