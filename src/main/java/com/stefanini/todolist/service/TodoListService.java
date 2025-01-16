package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoList;

import java.util.List;

public interface TodoListService {
    TodoList createTodoList(TodoList todoList, Long userId);
    TodoList getTodoListById(Long id);
    List<TodoList> getTodoListsByUserId(Long userId);
}
