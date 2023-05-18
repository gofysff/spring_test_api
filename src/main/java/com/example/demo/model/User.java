package com.example.demo.model;

import com.example.demo.entity.UserEntity;

public class User {
    private Long id;

    private  String username;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static User fromUserEntity(UserEntity userEntity){
        Long id = userEntity.getId();
        String username = userEntity.getUsername();
        return new User(id, username);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
