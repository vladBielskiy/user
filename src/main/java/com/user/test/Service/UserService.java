package com.user.test.Service;

import com.user.test.Dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    List<UserDto> findAllUsers();

    UserDto updateUser(UserDto user);

    String deleteUser(UserDto user);
}
