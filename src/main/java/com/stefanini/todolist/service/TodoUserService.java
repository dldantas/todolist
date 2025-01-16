package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoUser;

import java.util.List;

public interface TodoUserService {
    TodoUser createUser(TodoUser user);
    TodoUser getUserById(Long id);
    List<TodoUser> getAllUsers();
}