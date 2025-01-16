package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoItem;

import java.util.List;

public interface TodoItemService {
    TodoItem createItem(Long todoListId, TodoItem item);
    TodoItem getItemById(Long id);
    List<TodoItem> getItemsByListId(Long todoListId);
    TodoItem updateItem(Long id, TodoItem item);
    void deleteItem(Long id);
    TodoItem toggleComplete(Long id);
}