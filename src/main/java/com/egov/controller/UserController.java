package com.egov.controller;


import com.egov.dto.JwtAuthResponse;
import com.egov.dto.UserDto;
import com.egov.dto.UserLoginDto;
import com.egov.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {

        UserDto registerUser = userService.registerUser(userDto);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLoginDto) {

        JwtAuthResponse jwtAuthResponse = userService.loginUser(userLoginDto);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
