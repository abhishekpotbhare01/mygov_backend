package com.egov.service;

import com.egov.dto.JwtAuthResponse;
import com.egov.dto.UserDto;
import com.egov.dto.UserLoginDto;
import com.egov.entity.Role;
import com.egov.entity.User;
import com.egov.repository.UserRepository;
import com.egov.utils.Jwtutils;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private Jwtutils jwtutils;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, Jwtutils jwtutils, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtutils = jwtutils;
        this.authenticationManager = authenticationManager;
    }


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDto registerUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User saveUser = userRepository.save(user);

        userDto = modelMapper.map(saveUser, UserDto.class);

        return userDto;
    }

    @Override
    public JwtAuthResponse loginUser(UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginDto.getEmail(),
                userLoginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtutils.generateToken(authentication);

        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getEmail());
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        Role role = null;
        if (userOptional.isPresent()) {
            User loggedInUser = userOptional.get();
            role = loggedInUser.getRole();
            UserDto userDto = modelMapper.map(loggedInUser, UserDto.class);
            jwtAuthResponse.setUserDto(userDto);
        }

        jwtAuthResponse.setRole(role);
        jwtAuthResponse.setAccessToken(token);

        return jwtAuthResponse;
    }

    @Override
    public User findById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not found"));

        return user;
    }

    @Override
    public User saveOrUpdate(User user) {

        return userRepository.save(user);

    }

    @Override
    public void delete(Integer userId) {

    }
}
