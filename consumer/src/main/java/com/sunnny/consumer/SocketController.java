package com.sunnny.consumer;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class SocketController {
    //客户端在启动类里面直接调用

    public  void getSocker()throws IOException{
        ServerSocket serverSocket = new ServerSocket(9900);
        while (true){
            System.out.println("SocketController:9900端口等待连接...");
            //阻塞方法
            Socket accept = serverSocket.accept();
            System.out.println("SocketController:9900端口有客户端连接了...");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(accept);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
    //测试用的本地静态方法
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9900);
        while (true){
            System.out.println("等待连接...");
            //阻塞方法
            Socket accept = serverSocket.accept();
            System.out.println("有客户端连接了...");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(accept);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
    //处理数据方法
    private  static void handler(Socket socket)throws IOException {
        System.out.println("线程ID是:"+Thread.currentThread().getId());
        byte[] bytes = new byte[1024];
        System.out.println("准备读数据...");
        int read = socket.getInputStream().read(bytes);
        if (read!=-1){
            System.out.println("接受客户端的消息是:"+new String(bytes)+Thread.currentThread().getId());
            System.out.println("线程ID是:"+Thread.currentThread().getId());

        }
        socket.getOutputStream().write("Hello,Clint".getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();



    }

}
