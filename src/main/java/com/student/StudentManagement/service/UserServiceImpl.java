package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.UserDto;
import com.student.StudentManagement.entities.User;
import com.student.StudentManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto saveUser(User user) {
        User savedUser = this.userRepository.save(user);
        return this.mapper.map(savedUser,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepository.findAll();
        List<UserDto>userDtos = users.stream().map(user -> this.mapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }
}
