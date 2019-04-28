package com.openHack.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

}
