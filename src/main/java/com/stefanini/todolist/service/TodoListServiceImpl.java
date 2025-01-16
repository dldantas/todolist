package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoList;
import com.stefanini.todolist.model.TodoUser;
import com.stefanini.todolist.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import util.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;
    private final TodoUserService userService;

    @Override
    public TodoList createTodoList(TodoList todoList, Long userId) {
        TodoUser user = userService.getUserById(userId);
        todoList.setUser(user);
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList getTodoListById(Long id) {
        return todoListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lista não encontrado"));
    }

    @Override
    public List<TodoList> getTodoListsByUserId(Long userId) {
        return todoListRepository.findByUserId(userId);
    }
}
