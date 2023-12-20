package com.arhs.todolist.service;

import com.arhs.todolist.dto.UserDTO;
import com.arhs.todolist.mapper.Mapper;
import com.arhs.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arhs.todolist.mapper.Mapper;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final Mapper mapper;


    public UserService(Mapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> selectUser(int userId) {
        return mapper.toUserDto(userRepository.findById(userId));
    }
}
