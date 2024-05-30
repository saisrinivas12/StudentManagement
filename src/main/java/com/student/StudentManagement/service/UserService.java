package com.student.StudentManagement.service;

import com.student.StudentManagement.dto.UserDto;
import com.student.StudentManagement.entities.User;

import java.util.List;

public interface UserService {

    UserDto saveUser(User user);

    List<UserDto>getAllUsers();
}
