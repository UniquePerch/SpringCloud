package com.example.rabbitmq;

import com.example.rabbitmq.eneity.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitMqApplicationTests {
    @Resource
    RabbitTemplate template;

    @Test
    void producer(){
        User user = new User();
        user.setId(1);
        user.setName("1");
        template.convertAndSend("amq.direct","my-yyds",user);
    }
}
