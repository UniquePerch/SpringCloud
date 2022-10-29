package com.example;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class SpringCloudShardingJdbcApplicationTests {
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        for (int i = 10; i < 20; i++) {
            userMapper.addUser(new User("aaa", "bbb"));
        }
    }

    @Test
    void select(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }

}
