package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundedException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Object> registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return new ResponseEntity<>("Пользователь успешно сохранен", HttpStatus.CREATED);
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка регистрации");
        }
    }

    @GetMapping
    public ResponseEntity<Object> getOne(@RequestParam Long id){
        // this is what written after ? in request (?id=1)
        try{
            return ResponseEntity.ok(userService.getOneUser(id));
        }
        catch (UserNotFoundedException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        // same name var like in path
        try{
            return ResponseEntity.ok(userService.delete(id));
        }

        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
