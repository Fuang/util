/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * TODO 类的描述
 *
 * @author: Huangpf  Date: 2016/6/17 Time: 7:43.
 */
public class SocketCallable<T> implements Callable<T> {
    private Socket socket = null;

    public SocketCallable(Socket socket){
        this.socket = socket;
    }

    public T call() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        return null;
    }
}
