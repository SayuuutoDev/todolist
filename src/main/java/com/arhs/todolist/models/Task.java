package com.arhs.todolist.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "title")
    //@NotNull(message = "Title cannot be null")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Boolean completed;

    @Column(name = "user_id")
    private Integer userId;

    @Transient
    private User user;
}
