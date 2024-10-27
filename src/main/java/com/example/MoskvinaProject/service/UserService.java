package com.example.MoskvinaProject.service;

import com.example.MoskvinaProject.dto.UserDto;
import com.example.MoskvinaProject.entity.User;

import java.util.List;

public interface UserService {
    void saveUser (UserDto userDto);
    User findUserByEmail (String email);
    List<UserDto> findAllUsers ();

}
