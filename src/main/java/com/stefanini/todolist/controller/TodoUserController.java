package com.stefanini.todolist.controller;

import com.stefanini.todolist.model.TodoUser;
import com.stefanini.todolist.service.TodoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class TodoUserController {
    private final TodoUserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoUser createUser(@Validated @RequestBody TodoUser user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public TodoUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<TodoUser> getAllUsers() {
        return userService.getAllUsers();
    }
}