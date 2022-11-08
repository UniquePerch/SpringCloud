package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfiguration {
    @Bean("topicExchange")  //这里使用预置的Topic类型交换机
    public Exchange topicexchange(){
        return ExchangeBuilder.topicExchange("amq.topic").build();
    }

    @Bean("topicyydsQueue")
    public Queue queue(){
        return QueueBuilder
                .nonDurable("topicQueue")
                .build();
    }

    @Bean("topicbinding")
    public Binding topicbinding(@Qualifier("topicExchange") Exchange exchange,
                                @Qualifier("topicyydsQueue") Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("*.test.*")
                .noargs();
    }
}
