package com.huangpf.util.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by liaogd on 2015/11/8.
 */
@Aspect
@Component
public class SleepHelper {
    
    public SleepHelper() {
        
    }

    @Pointcut("execution(* *.sleep())")
    public void sleeppoint(){
    }

    @AfterReturning("sleeppoint()")
    public void afterSleep() {

        System.out.println(" sleep 后置拦截器...");

    }

    @Before("sleeppoint()")
    public void beforeSleep() {

        System.out.println(" sleep 前置拦截器...");
    }
    
}
