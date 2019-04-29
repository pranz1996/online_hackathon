package com.openHack.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.entity.UserEntity;
import com.openHack.service.JoinRequestService;
import com.openHack.shared.dto.JoinRequestDto;
import com.openHack.ui.model.request.JoinRequestDetailsModel;

@RestController
@RequestMapping("joinrequest")	// http://localhost:8080/joinrequest
public class OrganizationJoinRequestController {
	
	@Autowired
	JoinRequestService joinRequestService;
	
	// user send join request to any organization
	@PostMapping("/send")  
	public String sendJoinRequest(@RequestBody JoinRequestDetailsModel sendJoinRequestDetailsModel) {
		
		// JoinRequestDetailsModel object: input request data
		
		JoinRequestDto joinRequestDto = new JoinRequestDto();
		BeanUtils.copyProperties(sendJoinRequestDetailsModel, joinRequestDto);
	
		// Service method Call to create a request 
		joinRequestService.createRequest(joinRequestDto);
		
		return "The Join request to organization sent successfully ... ";
	}
	
	 // organization accept the join request of user
	@PostMapping("/accept")
	public String acceptJoinRequest(@RequestBody JoinRequestDetailsModel acceptJoinRequestDetailsModel) {
		
		// JoinRequestDetailsModel object: input request data
		
		JoinRequestDto joinRequestDto = new JoinRequestDto();
		BeanUtils.copyProperties(acceptJoinRequestDetailsModel, joinRequestDto);
		
		// Service method Call to accept a request 
		joinRequestService.acceptRequest(joinRequestDto);
		
		return "successfully accepted the join request";
	}
	
	 // show all sent request of user to organization(s)
	@GetMapping(path = "/sent/{id}")
	public List<String> sentJoinRequest(@PathVariable long id) {
		
		// Service method Call to get All organization details 
		List<OrganizationEntity> returnValue = joinRequestService.getOrganizations(id);
		
		// System.out.println(returnValue);
		
		// Temporary organizations' data
		List<String> organizations = new ArrayList<>();
		for(OrganizationEntity entity : returnValue) {
			organizations.add(entity.getName());
		}
		
		return organizations;
	}
	
	// show all request from users to any organization
	@GetMapping(path = "/have/{id}") 
	public List<String> hasJoinRequest(@PathVariable long id) {
		
		// Service method Call to get All user details 
		List<UserEntity> returnValue = joinRequestService.getUsers(id);
		
		// System.out.println(returnValue);
		
		// Temporary users' data
		List<String> users = new ArrayList<>();
		for(UserEntity entity : returnValue) {
			users.add(entity.getUserName());
		}
		
		return users;
	}
	
	// join request deny by any organization
	@PostMapping("/deny") 
	public String denyJoinRequest() { 
		return "successfully denied, the join request";
	}
}
	