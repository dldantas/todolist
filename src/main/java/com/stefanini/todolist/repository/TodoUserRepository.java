package com.stefanini.todolist.repository;

import com.stefanini.todolist.model.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {
    Optional<TodoUser> findByUsername(String username);
}
