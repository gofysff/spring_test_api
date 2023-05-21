package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private  TodoService todoService;

    @GetMapping
    public ResponseEntity<?> getTodo(@RequestParam Long todoId){
        try{
           TodoEntity todoEntity =  todoService.getTodo(todoId);
           Todo todoModel = Todo.fromEntity(todoEntity);
           return ResponseEntity.ok(todoModel);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId){
        try {
            TodoEntity todoEntity = todoService.createTodo(todo, userId);
            Todo todoModel = Todo.fromEntity(todoEntity);
            return ResponseEntity.ok(todoModel);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
           }
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestParam Long id){
        try {
            TodoEntity todoEntity = todoService.updateTodoIsComplete(id);
            Todo todoModel = Todo.fromEntity(todoEntity);
            return ResponseEntity.ok(todoModel);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
