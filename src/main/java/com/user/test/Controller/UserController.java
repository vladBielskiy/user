package com.user.test.Controller;

import com.user.test.Dto.UserDto;
import com.user.test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto userDto = userService.createUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
      UserDto userDto = userService.updateUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestBody UserDto user) {
        String deleted = userService.deleteUser(user);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.findAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }


}
