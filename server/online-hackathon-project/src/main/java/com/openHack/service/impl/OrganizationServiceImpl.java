package com.openHack.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.embeddedEntity.Address;
import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.repository.OrganizationRepository;
import com.openHack.service.OrganizationService;
import com.openHack.shared.dto.OrganizationDto;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	// service method to store organization object to database
	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {
		
		// DTO object to Entity object transfer
		OrganizationEntity organizationEntity = new OrganizationEntity();
		BeanUtils.copyProperties(organizationDto, organizationEntity);
		
		// Repository method (save) to save OrganizationEntity object to table organizations
		OrganizationEntity storedOrganizationDetails = organizationRepository.save(organizationEntity);
		
		// returning the saved object to UI
		OrganizationDto returnValue = new OrganizationDto();
		BeanUtils.copyProperties(storedOrganizationDetails, returnValue);
		
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
