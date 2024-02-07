package com.sparta.springauth.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoRequestDto {

    private String username;
    private String title;
    private String content;

    public TodoRequestDto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
