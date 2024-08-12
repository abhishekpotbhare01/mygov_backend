package com.egov.service;

import com.egov.dto.JwtAuthResponse;
import com.egov.dto.UserDto;
import com.egov.dto.UserLoginDto;
import com.egov.entity.User;

public interface IUserService {

    UserDto registerUser(UserDto userDto);

    JwtAuthResponse loginUser(UserLoginDto userLoginDto);

    User findById(Integer userId);

    User saveOrUpdate(User user);

    void delete(Integer userId);


}
