package com.example.demo.model;

import com.example.demo.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean isCompleted;

    public Todo() {}

    public static Todo fromEntity(TodoEntity todoEntity) {
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setTitle(todoEntity.getTitle());
        todo.setCompleted(todoEntity.getIsCompleted());
        return todo;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
