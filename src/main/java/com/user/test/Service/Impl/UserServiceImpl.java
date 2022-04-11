package com.user.test.Service.Impl;

import com.user.test.Dto.UserDto;
import com.user.test.Entity.User;
import com.user.test.Repository.UserRepository;
import com.user.test.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto user) {
        User usr = userRepository.save(mapper.map(user, User.class));
        return mapper.map(usr, UserDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(x -> mapper.map(x, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        userRepository.save(mapper.map(user, User.class));
        return user;
    }

    @Override
    public String deleteUser(UserDto user) {
       userRepository.delete(mapper.map(user,User.class));
        return "User with id:= " + user.getId() + " was deleted";
    }
}
