package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.TodoEntity;
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
