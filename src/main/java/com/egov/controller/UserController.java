package com.egov.controller;


import com.egov.dto.JwtAuthResponse;
import com.egov.dto.ResetPasswordDto;
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
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDto request) {
        try {
            userService.resetPassword(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Password reset successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error resetting password. Please try again.");
        }
    }

}
