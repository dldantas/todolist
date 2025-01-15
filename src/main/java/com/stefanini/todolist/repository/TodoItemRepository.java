package com.stefanini.todolist.repository;

import com.stefanini.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByTodoListId(Long todoListId);
    List<TodoItem> findByTodoListIdAndCompleted(Long todoListId, boolean completed);
}