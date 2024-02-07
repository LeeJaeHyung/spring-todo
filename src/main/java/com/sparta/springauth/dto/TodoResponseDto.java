package com.sparta.springauth.dto;

import com.sparta.springauth.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private boolean complete;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.username = todo.getUsername();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.complete = todo.isComplete();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}