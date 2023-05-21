package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;


import com.example.demo.exception.TodoNotFoundedException;
import com.example.demo.exception.UserNotFoundedException;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepo userRepo;

    public TodoEntity getTodo(Long todoId) throws TodoNotFoundedException {
        try {
            return todoRepository.findById(todoId).get();
        } catch (NoSuchElementException e){
            throw new TodoNotFoundedException("задача не найдена");
        }
    }

    public TodoEntity createTodo(TodoEntity todo, Long userId) throws UserNotFoundedException {
        try{
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return todoRepository.save(todo);}
        catch (Exception e){
            throw new UserNotFoundedException("Пользователь не найден");
        }
    }

    public TodoEntity updateTodoIsComplete(Long todoId) throws UserNotFoundedException {
        try {
            TodoEntity todo = todoRepository.findById(todoId).get();
            todo.setIsCompleted(!todo.getIsCompleted());
            return todoRepository.save(todo);
        } catch (Exception e) {
            throw new UserNotFoundedException("Пользователь не найден");
        }
    }
}
