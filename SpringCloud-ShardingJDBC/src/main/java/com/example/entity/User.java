package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    Long id;
    String name;
    String passwd;

    public User(String name,String passwd){
        this.name = name;
        this.passwd = passwd;
    }
}