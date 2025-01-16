package com.stefanini.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TodoItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listId", nullable = false)
    private TodoList todoList;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    private LocalDateTime dueDate;

    private Integer priority;

    @Column(nullable = false)
    private Boolean isCompleted;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = LocalDateTime.now();
        if (isCompleted == null) {
            isCompleted = false;
        }
        if (priority == null) {
            priority = 0;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}