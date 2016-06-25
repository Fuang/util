package com.huangpf.util.spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by liaogd on 2015/11/8.
 */
@Component
public class Human implements Sleepable {


    @Override
    public void sleep() {
        System.out.println("执行sleep...");
    }

}
