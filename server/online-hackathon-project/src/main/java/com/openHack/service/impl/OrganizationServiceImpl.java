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
		
		// Fetch Organization 
		OrganizationEntity existingOrganizationWithSameName = organizationRepository.findByName(organizationDto.getName());
		// To check if organization already exists ... 
		if(existingOrganizationWithSameName != null)
			throw new RuntimeException("Organization with name already exists ... ");
		
		organizationEntity.setName(organizationDto.getName());
		organizationEntity.setDescription(organizationDto.getDescription());
		organizationEntity.setAddress(organizationDto.getAddress());
		
		// If owner has created any organization before
		OrganizationEntity existingOrganizationWithSameOwnerID = organizationRepository.findByOwnerId(organizationDto.getUserEntity().getId());
		
		// To check if user is associated with any organization
		if(existingOrganizationWithSameOwnerID != null)
			throw new RuntimeException("User is owner of any other organization ... ");
		
		// Setting Owner
		UserEntity userEntity = userRepository.findById(organizationDto.getUserEntity().getId());
		organizationEntity.setUserEntity(userEntity);

		// Repository method (save) to save OrganizationEntity object to table organizations
		OrganizationEntity savedOrganization = organizationRepository.save(organizationEntity);
					
		OrganizationDto returnValue = new OrganizationDto();
		BeanUtils.copyProperties(savedOrganization, returnValue);
		
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
