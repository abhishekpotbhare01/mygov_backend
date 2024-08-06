package com.egov.service;

import com.egov.dto.UserDto;
import com.egov.dto.UserLoginDto;
import com.egov.entity.User;
import com.egov.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDto registerUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        User saveUser = userRepository.save(user);

        userDto = modelMapper.map(saveUser, UserDto.class);

        return userDto;
    }

    @Override
    public UserDto loginUser(UserLoginDto userLoginDto) {

        User user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }
}
