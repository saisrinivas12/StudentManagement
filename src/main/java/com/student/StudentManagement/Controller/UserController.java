package com.student.StudentManagement.Controller;

import com.student.StudentManagement.dto.UserDto;
import com.student.StudentManagement.entities.User;
import com.student.StudentManagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public ResponseEntity<?>saveUser(@RequestBody UserDto userDto){
        User user = this.mapper.map(userDto,User.class);
        String encryptedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        UserDto userDto1 = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDto1);
    }

    public ResponseEntity<?>getAllUsers(){
        List<UserDto> userDtos = this.userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDtos);
    }
}
