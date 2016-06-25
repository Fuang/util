/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.spring.annotation;

import org.springframework.stereotype.Component;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/23 Time: 9:27.
 */
@Component//可加参数，表示id=testcar，不加时为默认类名小写
public class Car {

    private String brand;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(){
        this.brand = "红旗Component";
        this.price = 2000000d;
    }

    @Override
    public String toString() {
        return "brand:" + brand + "," + "price:" + price;
    }
}
