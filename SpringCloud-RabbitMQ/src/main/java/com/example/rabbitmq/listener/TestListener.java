package com.example.rabbitmq.listener;

import com.example.rabbitmq.eneity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {
    @RabbitListener(queues = "dl-yyds", messageConverter = "jacksonConverter")
    public void receiver(User user){
        System.out.println(user);
    }

    @RabbitListener(queues = "fanoutyyds1",  containerFactory = "listenerContainer")
    public void receiver(String data){
        System.out.println("一号消息队列监听器 "+data);
    }

    @RabbitListener(queues = "fanoutyyds2", containerFactory = "listenerContainer")
    public void receiver2(String data){
        System.out.println("二号消息队列监听器 "+data);
    }
}
