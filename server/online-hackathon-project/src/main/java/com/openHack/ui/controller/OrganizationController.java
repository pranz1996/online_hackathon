package com.openHack.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openHack.io.entity.UserEntity;
import com.openHack.service.OrganizationService;
import com.openHack.shared.dto.OrganizationDto;
import com.openHack.ui.model.request.OrganizationDetailsRequestModel;
import com.openHack.ui.model.response.OrganizationDetailsResponseModel;

@RestController
@RequestMapping("organizations")  // http://localhost:8080/organizations
@CrossOrigin(origins = "http://localhost:3000")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
		
	// create and add new organization
	@PostMapping
	public OrganizationDetailsResponseModel createOrganization(@RequestBody OrganizationDetailsRequestModel organizationRequestModel) {
		
		// OrganizationRequestModel object: contains input request data
		
		// response model to send data to UI
		OrganizationDetailsResponseModel returnModel = new OrganizationDetailsResponseModel();
		
		// DTO object to hold the input request data
		OrganizationDto organizationDto = new OrganizationDto();
		
		// transferring input data to DTO object
		organizationDto.setName(organizationRequestModel.getName());
		organizationDto.setDescription(organizationRequestModel.getDescription());
		organizationDto.setAddress(organizationRequestModel.getAddress());
		UserEntity userEntity = new UserEntity();
		userEntity.setId(organizationRequestModel.getOwnerId());
		organizationDto.setUserEntity(userEntity);
		
		// Service method Call to insert data
		OrganizationDto createOrganization = organizationService.createOrganization(organizationDto);
		// Transferring DTO object data to response model
		
		returnModel.setId(createOrganization.getId());
		returnModel.setName(createOrganization.getName());
		returnModel.setDescription(createOrganization.getDescription());
		returnModel.setAddress(createOrganization.getAddress());
		returnModel.setOwnerId(createOrganization.getUserEntity().getId());
	
		return returnModel;
	}
	
	// get any organization by id
	@GetMapping(path = "/{id}")
	public OrganizationDetailsResponseModel getOrganization(@PathVariable long id) {
		
		// response model to send data to UI
		OrganizationDetailsResponseModel returnModel = new OrganizationDetailsResponseModel();
		
		// Service method Call to get organization data based on id
		OrganizationDto organizationDetails = organizationService.getOrganizationById(id);
		// transferring DTO object data to response model
		BeanUtils.copyProperties(organizationDetails, returnModel);
		
		return returnModel;
	}
	
	// update any organization
	@PutMapping(path = "/{id}")
	public OrganizationDetailsResponseModel updateOrganization(@PathVariable long id, @RequestBody OrganizationDetailsRequestModel organizationRequestModel) {
		
		// OrganizationRequestModel object: contains input request data
		
		// response model to send data to UI
		OrganizationDetailsResponseModel returnModel = new OrganizationDetailsResponseModel();
		
		// DTO object to hold the input request data
		OrganizationDto organizationDto = new OrganizationDto();
		// transferring input data to DTO object
		BeanUtils.copyProperties(organizationRequestModel, organizationDto);
		
		// Service method Call to update data
		OrganizationDto updatedOrganization = organizationService.updateOrganization(id, organizationDto);
		// Transferring DTO object data to response model
		BeanUtils.copyProperties(updatedOrganization, returnModel);
		
		return returnModel;
	}
	
	// delete any organization
	public String deleteOrganization() {
		return "delete organization was called";
	}
}
