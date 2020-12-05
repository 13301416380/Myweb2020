package com.sunny.rabbitmq.helloworld;

import com.sunny.rabbitmq.bo.Userinfos;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：不许人间见白头 Time：2020/11/29 2:29
 */
@Configuration
public class MyBean {
        @Bean
        public Userinfos Queue() {
                return new Userinfos("hello");
        }
}
