package com.arhs.todolist.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "description cannot be blank")
    private String description;
    private Boolean completed;
    private Integer userId;
}