package com.arhs.todolist.service;

import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.mapper.Mapper;
import com.arhs.todolist.models.Task;
import com.arhs.todolist.repository.TaskRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final Mapper mapper;
    private final TaskRepository taskRepository;


    public TaskService(Mapper mapper, TaskRepository taskRepository) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> listTasks() {
        return mapper.toTaskDto(taskRepository.findAll());
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        return mapper.toDto(taskRepository.save(mapper.toTask(taskDTO)));
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Optional<TaskDTO> selectTask(int taskId) {
        return mapper.toTaskDto(taskRepository.findById(taskId));
    }


}
