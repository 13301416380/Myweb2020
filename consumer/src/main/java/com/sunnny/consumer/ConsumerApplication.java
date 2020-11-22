package com.sunnny.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.security.x509.IPAddressName;

import java.io.IOException;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ConsumerApplication.class, args);
        //调动socket服务器 端口9900
        SocketController socketController = new SocketController();
        socketController.getSocker();
    }

}
