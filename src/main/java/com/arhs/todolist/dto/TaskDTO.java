package com.arhs.todolist.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private int taskId;
    @Pattern(regexp = "^(?!.*test).*$", message = "Title cannot be 'test'")
    private String title;
    private String description;
    private Boolean completed;
    private Integer userId;
}