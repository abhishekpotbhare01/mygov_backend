package com.egov.service;

import com.egov.dto.UserDto;
import com.egov.dto.UserLoginDto;
import com.egov.entity.User;

public interface IUserService {

    UserDto registerUser(UserDto userDto);

    UserDto loginUser(UserLoginDto userLoginDto);
}
