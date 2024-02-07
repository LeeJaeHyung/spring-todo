package com.sparta.springauth.controller;

import com.sparta.springauth.dto.TodoRequestDto;
import com.sparta.springauth.dto.TodoResponseDto;
import com.sparta.springauth.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto createdTodo = todoService.createTodo(todoRequestDto);
        return ResponseEntity.ok(createdTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long id) {
        TodoResponseDto todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos() {
        List<TodoResponseDto> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto) {
        TodoResponseDto updatedTodo = todoService.updateTodo(id, todoRequestDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeTodo(@PathVariable Long id) {
        todoService.completeTodo(id);
        return ResponseEntity.ok().build();
    }
}
