package com.arhs.todolist.service;

import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.mapper.TaskMapper;
import com.arhs.todolist.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;


    public TaskService(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> listTasks() {
        return taskMapper.toTaskDto(taskRepository.findAll());
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toTask(taskDTO)));
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public Optional<TaskDTO> selectTask(int taskId) {
        return taskMapper.toTaskDto(taskRepository.findById(taskId));
    }


}
