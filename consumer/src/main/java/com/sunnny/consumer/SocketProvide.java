package com.sunnny.consumer;

import java.io.IOException;
import java.net.Socket;

public class SocketProvide {
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("127.0.0.1",9900);
        //向服务器发送数据
        socket.getOutputStream().write("Hello Server".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束!");
        //接受服务端数据
        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        System.out.println("接受服务端的数据是:"+new String(bytes));
        socket.close();
    }
}
