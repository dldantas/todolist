package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoUser;
import com.stefanini.todolist.repository.TodoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import util.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class TodoUserServiceImpl implements TodoUserService {
    private final TodoUserRepository userRepository;

    public TodoUserServiceImpl(TodoUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public TodoUser createUser(TodoUser user) {
        return userRepository.save(user);
    }

    @Override
    public TodoUser getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @Override
    public List<TodoUser> getAllUsers() {
        return userRepository.findAll();
    }
}