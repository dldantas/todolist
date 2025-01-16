package com.stefanini.todolist.service;

import com.stefanini.todolist.model.TodoItem;
import com.stefanini.todolist.model.TodoList;
import com.stefanini.todolist.repository.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import util.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoItemServiceImpl implements TodoItemService {
    private final TodoItemRepository itemRepository;
    private final TodoListService todoListService;

    @Override
    public TodoItem createItem(Long todoListId, TodoItem item) {
        TodoList todoList = todoListService.getTodoListById(todoListId);
        item.setTodoList(todoList);
        return itemRepository.save(item);
    }

    @Override
    public TodoItem getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("item não encontrado"));
    }

    @Override
    public List<TodoItem> getItemsByListId(Long todoListId) {
        return itemRepository.findByTodoListId(todoListId);
    }

    @Override
    public TodoItem updateItem(Long id, TodoItem item) {
        TodoItem existingItem = getItemById(id);
        existingItem.setTitle(item.getTitle());
        existingItem.setDescription(item.getDescription());
        existingItem.setIsCompleted(item.getIsCompleted());
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResourceNotFoundException("item não encontrado");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public TodoItem toggleComplete(Long id) {
        TodoItem item = getItemById(id);
        item.setIsCompleted(!item.getIsCompleted());
        return itemRepository.save(item);
    }
}