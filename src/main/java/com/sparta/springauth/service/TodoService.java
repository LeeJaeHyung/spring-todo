package com.sparta.springauth.service;

import com.sparta.springauth.dto.TodoRequestDto;
import com.sparta.springauth.dto.TodoResponseDto;
import com.sparta.springauth.entity.Todo;
import com.sparta.springauth.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto) {
        Todo todo = new Todo(todoRequestDto);
        todoRepository.save(todo);
        return new TodoResponseDto(todo);
    }

    public TodoResponseDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 할 일이 없습니다: " + id));
        return new TodoResponseDto(todo);
    }

    public List<TodoResponseDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAllByOrderByCreatedAtDesc();
        return allTodos.stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    public TodoResponseDto updateTodo(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 할 일이 없습니다: " + id));

        todo.setTitle(todoRequestDto.getTitle());
        todo.setContent(todoRequestDto.getContent());

        todoRepository.save(todo);
        return new TodoResponseDto(todo);
    }

    public void completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 할 일이 없습니다: " + id));

        todo.setComplete(true);
        todoRepository.save(todo);
    }
}
