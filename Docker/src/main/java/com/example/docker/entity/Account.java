package com.example.docker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_account")
public class Account {

    @Column(name = "id")
    @Id
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;
}