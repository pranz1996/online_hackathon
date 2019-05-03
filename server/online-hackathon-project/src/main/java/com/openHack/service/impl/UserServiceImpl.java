package com.openHack.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.embeddedEntity.Address;
import com.openHack.io.entity.UserEntity;
import com.openHack.io.repository.UserRepository;
import com.openHack.service.UserService;
import com.openHack.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	// service method to store user object to database
	@Override
	public UserDto createUser(UserDto userDto) {
		
		// check for Admin or not -> email ends with @sjsu.edu 
		String email = userDto.getEmail();
		if(email.endsWith("@sjsu.edu"))
			userDto.setAdminCheck(true);
		
		// User with email id already exists or not
		UserEntity existingUserDetails = userRepository.findByEmail(userDto.getEmail());
		// if exists then throwing an error
		if(existingUserDetails != null)
			throw new RuntimeException("User with email already exists ... ");
		
		// DTO object to Entity object transfer
		UserEntity userEntity = new UserEntity();
		
		
		BeanUtils.copyProperties(userDto, userEntity);
		
		// Repository method (save) to save UserEntity object to table users
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		// returning the saved object to UI
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	
	// Service method to get any user based on it's id(primary key)
	@Override
	public UserDto getUserById(long id) {
		
		// returning object to UI
		UserDto returnValue = new UserDto();
		
		// Repository method (findById()) to fetch user details
		UserEntity userEntity = userRepository.findById(id);
		
		// Entity object to DTO object transfer
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto updateUser(long id, UserDto userDto) {
		
		// returning object to UI
		UserDto returnValue = new UserDto();
		
		// Repository method (findById()) to fetch user details
		UserEntity userEntity = userRepository.findById(id);
		
		// updating the fields for userEntity
		userEntity.setPortraitUrl(userDto.getPortraitUrl());
		userEntity.setTitle(userDto.getTitle());
		userEntity.setAbout(userDto.getAbout());
		
		Address updatedAddress = userDto.getAddress();
		userEntity.setAddress(updatedAddress);
		
		// Repository method (save) to save updated UserEntity object to table users
		UserEntity updatedUser = userRepository.save(userEntity);
		
		ObjectMapper mapper = new ObjectMapper();
		returnValue = mapper.convertValue(updatedUser, UserDto.class);
		
		return returnValue;
	}

	// Login method automatically called by Spring Security
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		// if no user with requested email is found
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(email);
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
	}

	// Convenient method to find the user in database while LOGIN
	@Override
	public UserDto getUser(String email) {
		
		UserDto returnValue = new UserDto();
		
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(email);
		
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

}
