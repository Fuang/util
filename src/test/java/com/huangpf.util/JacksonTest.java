/*
* Copyright (c) 2014 Huangpf. All Rights Reserved.
*/
package com.huangpf.util;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * jackson主要用法的测试的测试类
 *
 * @author: Huangpf  Date: 2016/5/10 Time: 17:01.
 */
public class JacksonTest {
    public static Logger log = Logger.getRootLogger();

    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        String listJson = null;//list转json的字符串
        String mapJson = null;//map转json的字符串
        String stJson = null;//自建对象类转json的字符串

        //list 转json
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (int i=0;i<3;i++){
            Map<String, Object> maptmp = new HashMap<String, Object>();
            maptmp.put("key"+i, "value"+i);
            list.add(maptmp);
        }
        try {
            listJson = objectMapper.writeValueAsString(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("list转json：" + listJson);

        //map转json
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("LIST", list);
        try {
            mapJson = objectMapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("map转json：" + mapJson);

        //类对象转json
        map.clear();
        Student student = new Student();
        try {
            //直接输出时间格式会不对例："time":1463058549693  需要自己格式化
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

            stJson = objectMapper.writeValueAsString(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("类转json：" + stJson);

        //json转list
        list.clear();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Map.class);//设置解析为List<Map<String,Object>>，list里可为其他对象
        try {
            list = objectMapper.readValue(listJson, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("json转list：" + list);

        //json转map
        map.clear();
        try {
            map = objectMapper.readValue(mapJson, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("json转map：" + map);

        //json转对象
        try {
            //有时间的时候需要设置时间格式
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            student = objectMapper.readValue(stJson, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("json转类对象：" + student);
    }

    public static class Student{
        private int age=10;
        private String name="hhh";
        public String[] list={"hao","haouhao","keyi"};
        public Date time=new Date();

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}