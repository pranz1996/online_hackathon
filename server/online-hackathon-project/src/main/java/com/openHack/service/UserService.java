package com.openHack.service;

import com.openHack.shared.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto getUserById(long id);
	UserDto updateUser(long id, UserDto userDto);
}