package com.openHack.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.openHack.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDto);
	UserDto getUserById(long id);
	UserDto updateUser(long id, UserDto userDto);
	UserDto getUser(String email);
}