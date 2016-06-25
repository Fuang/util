/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.spring;

import com.huangpf.util.spring.annotation.Boss;
import com.huangpf.util.spring.aop.Sleepable;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/23 Time: 9:50.
 */
public class TestAnnotation {

    public static void main(String[] args){
        Logger log = Logger.getLogger(TestAnnotation.class);

        ApplicationContext ac = new FileSystemXmlApplicationContext("/src/main/resources/ApplicationContext.xml");
        Boss boss = (Boss) ac.getBean("boss");

        log.debug(boss.toString());

        Sleepable human = (Sleepable) ac.getBean("human");
        human.sleep();
    }

}
