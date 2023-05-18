package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/// it works with database
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    /// name of this method should be same like property what we try to find
    UserEntity findByUsername(String username);
}
