package com.openHack.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.embeddedEntity.Address;
import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.entity.UserEntity;
import com.openHack.io.repository.OrganizationRepository;
import com.openHack.io.repository.UserRepository;
import com.openHack.service.OrganizationService;
import com.openHack.shared.dto.OrganizationDto;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	// service method to store organization object to database
	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {
		
		// Converting DTO object to Entity object
		OrganizationEntity organizationEntity = new OrganizationEntity();
		BeanUtils.copyProperties(organizationDto, organizationEntity);
		
		// Fetch Organization 
		OrganizationEntity existingOrganization = organizationRepository.findByName(organizationEntity.getName());
		// To check if organization already exists ... 
		if(existingOrganization != null)
			throw new RuntimeException("Organization with name already exists ... ");
				
		// Fetch User
		UserEntity userEntity = userRepository.findById(organizationDto.getOwnerId());
		// To check if user is associated with any organization
		if(userEntity.getOrganizationEntity() != null) 
			throw new RuntimeException("User is already joined with any organization ... ");
		
		// adding new organization details for user 
		userEntity.setOrganizationEntity(organizationEntity);
		// removing all the sent request to organizations
		userEntity.setOrganizations(null);
		
		userEntity = userRepository.save(userEntity);
		
//		System.out.println(" user " + userEntity);
//		System.out.println(" user " + userEntity.getOrganizationEntity());
//		
	
		// return organizationEntity details
		organizationEntity = userEntity.getOrganizationEntity();
		
		//System.out.println(organizationEntity);
		
		OrganizationDto returnValue = new OrganizationDto();
		BeanUtils.copyProperties(organizationEntity, returnValue);
		
		return returnValue;
	}
	
	// Service method to get any organization based on it's id(primary key)
	@Override
	public OrganizationDto getOrganizationById(long id) {
		
		// returning object to UI
		OrganizationDto returnValue = new OrganizationDto();
		
		// Repository method (findById()) to fetch organization details
		OrganizationEntity organizationEntity = organizationRepository.findById(id);
		
		// Entity object to DTO object transfer
		BeanUtils.copyProperties(organizationEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public OrganizationDto updateOrganization(long id, OrganizationDto organizationDto) {
		
		// returning object to UI
		OrganizationDto returnValue = new OrganizationDto();
		
		// Repository method (findById()) to fetch organization details
		OrganizationEntity organizationEntity = organizationRepository.findById(id);
		
		// updating the fields for organizationEntity
		organizationEntity.setName(organizationEntity.getName());
		organizationEntity.setDescription(organizationDto.getDescription());
		
//		Address updatedAddress = organizationDto.getAddress();
//		organizationEntity.setAddress(updatedAddress);
	
		Address updateAddress = new Address();
		updateAddress.setStreet(organizationDto.getAddress().getStreet());
		updateAddress.setCity(organizationDto.getAddress().getCity());
		updateAddress.setState(organizationDto.getAddress().getState());
		updateAddress.setZip(organizationDto.getAddress().getZip());
		
		organizationEntity.setAddress(updateAddress);
		
		// Repository method (save) to save updated OrganizationEntity object to table organizations
		OrganizationEntity updatedOrganization = organizationRepository.save(organizationEntity);

		ObjectMapper mapper = new ObjectMapper();
		returnValue = mapper.convertValue(updatedOrganization, OrganizationDto.class);
		
		return returnValue;
	}

}
