package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public TodoEntity updateTodoIsComplete(Long todoId) {
        TodoEntity todo = todoRepository.findById(todoId).get();
        todo.setIsCompleted(!todo.getIsCompleted());
        return todoRepository.save(todo);
    }
}
