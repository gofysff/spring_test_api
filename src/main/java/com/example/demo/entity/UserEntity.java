package com.example.demo.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    // cascade delete all todos when user will be deleted
    // mappedBy -
    private List<TodoEntity> todos;
    public UserEntity(){}

    public UserEntity get(){
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }
}
