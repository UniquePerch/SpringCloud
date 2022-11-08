package com.publisher.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class PublisherController {
    @Resource
    StreamBridge bridge;  //通过bridge来发送消息

    @RequestMapping("/publish")
    public String publish(){
        //第一个参数其实就是RabbitMQ的交换机名称（数据会发送给这个交换机，到达哪个消息队列，不由我们决定）
        //这个交换机的命名稍微有一些规则:
        //输入:    <名称> + -in- + <index>
        //输出:    <名称> + -out- + <index>
        //这里我们使用输出的方式，来将数据发送到消息队列，注意这里的名称会和之后的消费者Bean名称进行对应
        bridge.send("test-out-0", "123123!");
        return "消息发送成功！"+new Date();
    }
}
