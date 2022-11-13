package com.example.docker.controller;

import com.example.docker.entity.Account;
import com.example.docker.repo.AccountRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MainController {

    @Resource
    AccountRepository repository;

    @Resource
    StringRedisTemplate template;

    @GetMapping("/take")
    public String take(@RequestParam("key") String key){
        return template.opsForValue().get(key);
    }

    @PostMapping("/put")
    public String  put(@RequestParam("key") String key,
                       @RequestParam("value") String value){
        template.opsForValue().set(key, value);
        return "操作成功！";
    }

    @RequestMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/get")
    public Account get(@RequestParam("id") long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/post")
    public Account get(@RequestParam("id") long id,
                       @RequestParam("name") String name,
                       @RequestParam("password") String password){
        return repository.save(new Account(id, name, password));
    }
}