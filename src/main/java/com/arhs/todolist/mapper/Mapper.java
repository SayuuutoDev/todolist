package com.arhs.todolist.mapper;

import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.dto.UserDTO;
import com.arhs.todolist.models.Task;
import com.arhs.todolist.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public TaskDTO toDto(Task task) {
        String title = task.getTitle();
        String description = task.getDescription();
        Integer userId = task.getUserId();
        Boolean status = task.getCompleted();
        Integer taskId = task.getTaskId();
        return TaskDTO.builder().taskId(taskId)
                .description(description)
                .userId(userId)
                .completed(status)
                .title(title)
                .build();
    }
    public List<TaskDTO> toTaskDto(List<Task> tasks) {
        return tasks.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public Optional<TaskDTO> toTaskDto(Optional<Task> task) {
        return task.map(this::toDto);
    }
    public Task toTask(TaskDTO taskDTO) {
        return Task.builder().taskId(taskDTO.getTaskId())
                .description(taskDTO.getDescription())
                .userId(taskDTO.getUserId())
                .completed(taskDTO.getCompleted())
                .title(taskDTO.getTitle())
                .build();
    }

    public UserDTO toDto(User user) {
        String name = user.getName();
        String image = user.getImage();
        Integer userId = user.getUserId();
        return UserDTO.builder().userId(userId)
                .name(name)
                .image(image)
                .build();
    }
    public List<UserDTO> toUserDto(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public Optional<UserDTO> toUserDto(Optional<User> user) {
        return user.map(this::toDto);
    }
    public User toUser(UserDTO userDTO) {
        return User.builder().userId(userDTO.getUserId())
                .name(userDTO.getName())
                .image(userDTO.getImage())
                .build();
    }
}