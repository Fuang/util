/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/23 Time: 9:26.
 */
public class Boss {
    private Car car;
    private Car car1;
    //类成员变量注解
    @Autowired
    private Office office;
    @Resource(name = "office1")
    private Office office1;
    @Resource(name = "office")
    private Office office2;

    public Car getCar() {
        return car;
    }

    //set方法注解
    @Autowired
    public void setCar(@Qualifier("car") Car car) {
        this.car = car;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    //构造方法注解
    @Autowired
    public Boss(Car car1){
        this.car1 = car1;
    }

    @Override
    public String toString() {
        return "car:" + car + "\n" + "office:" + office + "\ncar1:" + car1 + "\noffice1:" + office1+ "\noffice2:" + office2;
    }

    @PostConstruct
    public void postConstruct1(){
        System.out.println("postConstruct1");
    }

    @PreDestroy
    public void preDestroy1(){
        System.out.println("preDestroy1");
    }
}
