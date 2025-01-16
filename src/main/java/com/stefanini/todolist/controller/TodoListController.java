package com.stefanini.todolist.controller;

import com.stefanini.todolist.model.TodoList;
import com.stefanini.todolist.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-lists")
@RequiredArgsConstructor
public class TodoListController {
    private final TodoListService todoListService;

    @PostMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList createTodoList(
            @PathVariable Long userId,
            @Validated @RequestBody TodoList todoList ) {
        return todoListService.createTodoList(todoList, userId);
    }

    @GetMapping("/{id}")
    public TodoList getTodoListById(@PathVariable Long id) {
        return todoListService.getTodoListById(id);
    }

    @GetMapping("/users/{userId}")
    public List<TodoList> getTodoListsByUserId(@PathVariable Long userId) {
        return todoListService.getTodoListsByUserId(userId);
    }
}
