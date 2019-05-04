package com.openHack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.entity.UserEntity;
import com.openHack.io.repository.OrganizationRepository;
import com.openHack.io.repository.UserRepository;
import com.openHack.service.JoinRequestService;
import com.openHack.shared.dto.JoinRequestDto;

@Service
public class JoinRequestServiceImpl implements JoinRequestService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	// user send request to any organization
	@Override
	public void createRequest(JoinRequestDto joinRequestDto) {
	
		// Fetch user details 
		UserEntity userEntity = userRepository.findById(joinRequestDto.getUser_id());
	
		
		// To check if user is associated with any organization or not
		if(userEntity.getOrganizationEntity() != null) 
			throw new RuntimeException("User is already joined with any organization ... ");
		
		// Fetch organization details
		OrganizationEntity organizationEntity = organizationRepository.findById(joinRequestDto.getOrganization_id());
		
		// adding organization details in user entity
		userEntity.addOrganization(organizationEntity);
		
		// Repository method (save) to save UserEntity object to table users
		userRepository.save(userEntity);
	
	}

	// organization accept the join request of user
	@Override
	public void acceptRequest(JoinRequestDto joinRequestDto) {
		
		// Fetch organization details
		OrganizationEntity organizationEntity = organizationRepository.findById(joinRequestDto.getOrganization_id());
		
		// Fetch user details 
		UserEntity userEntity = userRepository.findById(joinRequestDto.getUser_id());
		
		// adding organization details in user entity
		userEntity.setOrganizationEntity(organizationEntity);
		
		// discarding all the send request of user
		userEntity.setOrganizations(null);
		
		// Repository method (save) to save UserEntity object to table users
		userRepository.save(userEntity);
		
	}

	// Get all the organizations, to which user has sent the request
	// show all sent request of user to organization(s)
	@Override
	public List<OrganizationEntity> getOrganizations(long id) {
		
		// Fetch user details 
		UserEntity userEntity = userRepository.findById(id);
		
		//System.out.println(userEntity);
		
		//System.out.println(userEntity.getOrganizations());
		
		// return all the organizations from join table
		return userEntity.getOrganizations();
	}
	
	// show all request from users to any organization
	// Get all the Users, by organization to check the request 
	@Override
	public List<UserEntity> getUsers(long id) {
		
		// Fetch organization details
		OrganizationEntity organizationEntity = organizationRepository.findById(id);
		
		// return all the users from join table
		return organizationEntity.getUsers();
	}
	
}
