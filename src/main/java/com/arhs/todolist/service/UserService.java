package com.arhs.todolist.service;

import com.arhs.todolist.dto.UserDTO;
import com.arhs.todolist.mapper.TaskMapper;
import com.arhs.todolist.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;


    public UserService(TaskMapper taskMapper, UserRepository userRepository) {
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> selectUser(int userId) {
        return taskMapper.toUserDto(userRepository.findById(userId));
    }
}
