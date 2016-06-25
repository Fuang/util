/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.thread;

/**
 * synchrosized的监听对象
 *
 * @author: Huangpf  Date: 2016/6/8 Time: 15:03.
 */
public class Message {

    private String msg;

    Message(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
