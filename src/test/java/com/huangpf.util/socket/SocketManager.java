/*
* Copyright (c) 2016 Huangpf. All Rights Reserved.
*/
package com.huangpf.util.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端
 *
 * @author: Huangpf  Date: 2016/6/16 Time: 18:02.
 */
public class SocketManager {
    private int port = 8888;
    private ServerSocket serverSocket = null;

    public SocketManager(){
        try {
            //初始化服务端对象
            serverSocket = new ServerSocket(port);
            //监听端口连接请求，
            Socket socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
