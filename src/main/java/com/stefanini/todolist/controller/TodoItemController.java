package com.stefanini.todolist.controller;

import com.stefanini.todolist.model.TodoItem;
import com.stefanini.todolist.service.TodoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-lists/{todoListId}/items")
@RequiredArgsConstructor
public class TodoItemController {
    private final TodoItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem createItem(
            @PathVariable Long todoListId,
            @Validated @RequestBody TodoItem item
    ) {
        return itemService.createItem(todoListId, item);
    }

    @GetMapping("/{id}")
    public TodoItem getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<TodoItem> getItemsByListId(@PathVariable Long todoListId) {
        return itemService.getItemsByListId(todoListId);
    }

    @PutMapping("/{id}")
    public TodoItem updateItem(
            @PathVariable Long id,
            @Validated @RequestBody TodoItem item
    ) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @PatchMapping("/{id}/toggle")
    public TodoItem toggleItemComplete(@PathVariable Long id) {
        return itemService.toggleComplete(id);
    }
}