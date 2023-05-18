package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundedException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundedException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundedException("Пользователь не найден");
        }
        return User.fromUserEntity(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
