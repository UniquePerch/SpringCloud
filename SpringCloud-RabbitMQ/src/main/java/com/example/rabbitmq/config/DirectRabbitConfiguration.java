package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//{"id":1,"name":"LB"}
import javax.annotation.Resource;

@Configuration
public class DirectRabbitConfiguration {
    @Resource
    private CachingConnectionFactory connectionFactory;

    @Bean(name = "listenerContainer") //监听管道设置
    public SimpleRabbitListenerContainerFactory listenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPrefetchCount(1);   //将PrefetchCount设定为1表示一次只能取一个
        return factory;
    }

    @Bean("directExchange")  //定义交换机Bean，可以很多个
    public Exchange exchange(){
        return ExchangeBuilder.directExchange("amq.direct").build();
    }

    @Bean("directyydsQueue")     //定义消息队列
    public Queue queue(){
        return QueueBuilder
                .nonDurable("directyyds")   //非持久化类型
                .deadLetterExchange("dlx.direct")   //指定死信交换机
                .deadLetterRoutingKey("dl-yyds")   //指定死信RoutingKey
                .maxLength(3)
                .build();
    }

    @Bean("directbinding")
    public Binding binding(@Qualifier("directExchange") Exchange exchange,
                           @Qualifier("directyydsQueue") Queue queue){
        //将我们刚刚定义的交换机和队列进行绑定
        return BindingBuilder
                .bind(queue)   //绑定队列
                .to(exchange)  //到交换机
                .with("my-yyds")   //使用自定义的routingKey
                .noargs();
    }

    @Bean("jacksonConverter")   //直接创建一个用于JSON转换的Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}