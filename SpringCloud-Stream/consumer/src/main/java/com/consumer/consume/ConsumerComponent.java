package com.consumer.consume;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerComponent {
    @Bean("test")   //注意这里需要填写我们前面交换机名称中"名称"，这样生产者发送的数据才会正确到达
    public Consumer<String> consumer(){
        return System.out::println;
    }
}
