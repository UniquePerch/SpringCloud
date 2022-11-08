package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfiguration {
    @Bean("fanoutExchange")
    public Exchange exchange1(){
        //注意这里是fanoutExchange,一个交换机获得消息直接散布给两个queue
        return ExchangeBuilder.fanoutExchange("amq.fanout").build();
    }

    @Bean("fanoutyydsQueue1")
    public Queue queue1(){
        return QueueBuilder.nonDurable("fanoutyyds1").build();
    }

    @Bean("fanoutbinding1")
    public Binding binding1(@Qualifier("fanoutExchange") Exchange exchange,
                            @Qualifier("fanoutyydsQueue1") Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("fanoutyyds1")
                .noargs();
    }

    @Bean("fanoutyydsQueue2")
    public Queue queue2(){
        return QueueBuilder.nonDurable("fanoutyyds2").build();
    }

    @Bean("fanoutbinding2")
    public Binding binding2(@Qualifier("fanoutExchange") Exchange exchange,
                            @Qualifier("fanoutyydsQueue2") Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("fanoutyyds2")
                .noargs();
    }
}
