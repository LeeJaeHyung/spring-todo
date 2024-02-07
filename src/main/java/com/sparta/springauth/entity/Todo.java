package com.sparta.springauth.entity;

import com.sparta.springauth.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "todos") //테이블 명이 todos로 생성 됨
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean complete;

    public Todo(TodoRequestDto todoRequestDto) {
        this.username = todoRequestDto.getUsername();
        this.title = todoRequestDto.getTitle();
        this.content = todoRequestDto.getContent();
    }



}
