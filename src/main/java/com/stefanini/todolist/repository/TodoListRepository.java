package com.stefanini.todolist.repository;

import com.stefanini.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findByUserId(Long userId);
}