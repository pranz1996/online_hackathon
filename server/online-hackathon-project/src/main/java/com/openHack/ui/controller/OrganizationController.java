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

import com.openHack.service.OrganizationService;
import com.openHack.shared.dto.OrganizationDto;
import com.openHack.ui.model.request.OrganizationRequestModel;
import com.openHack.ui.model.response.OrganizationResponseModel;

@RestController
@RequestMapping("organizations")  // http://localhost:8080/organizations
@CrossOrigin(origins = "http://localhost:3000")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
		
	
	// create and add new organization
	@PostMapping
	public OrganizationResponseModel createOrganization(@RequestBody OrganizationRequestModel organizationRequestModel) {
		
		// OrganizationRequestModel object: contains input request data
		
		// response model to send data to UI
		OrganizationResponseModel returnModel = new OrganizationResponseModel();
		
		// DTO object to hold the input request data
		OrganizationDto organizationDto = new OrganizationDto();
		// transferring input data to DTO object
		BeanUtils.copyProperties(organizationRequestModel, organizationDto);
		
		// Service method Call to insert data
		OrganizationDto createOrganization = organizationService.createOrganization(organizationDto);
		// Transferring DTO object data to response model
		BeanUtils.copyProperties(createOrganization, returnModel);

		return returnModel;
	}
	
	// get any organization by id
	@GetMapping(path = "/{id}")
	public OrganizationResponseModel getOrganization(@PathVariable long id) {
		
		// response model to send data to UI
		OrganizationResponseModel returnModel = new OrganizationResponseModel();
		
		// Service method Call to get organization data based on id
		OrganizationDto organizationDetails = organizationService.getOrganizationById(id);
		// transferring DTO object data to response model
		BeanUtils.copyProperties(organizationDetails, returnModel);
		
		return returnModel;
	}
	
	// update any organization
	@PutMapping(path = "/{id}")
	public OrganizationResponseModel updateOrganization(@PathVariable long id, @RequestBody OrganizationRequestModel organizationRequestModel) {
		
		// OrganizationRequestModel object: contains input request data
		
		// response model to send data to UI
		OrganizationResponseModel returnModel = new OrganizationResponseModel();
		
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
