package com.openHack.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openHack.service.HackathonService;
import com.openHack.shared.dto.HackathonDto;
import com.openHack.ui.model.request.HackathonDetailsRequestModel;
import com.openHack.ui.model.response.HackathonDetailsResposeModel;


@RestController
@RequestMapping("hackathons") // -> http://localhost:8080/hackathons
@CrossOrigin(origins = "http://localhost:3000")
public class HackathonController {
	
	@Autowired
	HackathonService hackathonService;
	
	// get any hackathon by id
	@GetMapping(path="/{id}")
	public HackathonDetailsResposeModel getHackathon(@PathVariable long id) {
		
		// response model to send data to UI
		HackathonDetailsResposeModel returnModel = new HackathonDetailsResposeModel();
					
		// Service method Call to get hackathon data based on id
		HackathonDto hackathonDetails = hackathonService.getHackathonById(id);
		
		// transferring DTO object data to response model
		ModelMapper mapper = new ModelMapper();
		returnModel = mapper.map(hackathonDetails, HackathonDetailsResposeModel.class);
		
		return returnModel;
	}
	
	// get all the hackathons 
	@GetMapping
	public String getHackathons() {
		return "get all Hackathon method was called";
	}
	
	// create and add new hackathon
	@PostMapping
	public HackathonDetailsResposeModel createHackathon(@RequestBody HackathonDetailsRequestModel hackathonDetailsRequestModel) {
		
		System.out.println(hackathonDetailsRequestModel);
		
		// HackathonDetailsRequestModel object: contains input request data
		
		// response model to send data to UI
		HackathonDetailsResposeModel returnModel = new HackathonDetailsResposeModel();
		
		// DTO object to hold the input request data
		HackathonDto hackathonDto = new HackathonDto();
		// transferring input data to DTO object
		ModelMapper mapper = new ModelMapper();
		hackathonDto = mapper.map(hackathonDetailsRequestModel, HackathonDto.class);
		System.out.println(hackathonDto);
		// Service method Call to insert data
		HackathonDto createHacathon = hackathonService.createHackthon(hackathonDto);
		// Transferring DTO object data to response model
		mapper = new ModelMapper();
		returnModel = mapper.map(createHacathon, HackathonDetailsResposeModel.class);
	
		return returnModel;
	}
	
	// update any hackathon details
	@PutMapping(path="/{id}")
	public HackathonDetailsResposeModel updateHackthon(@PathVariable long id, @RequestBody HackathonDetailsRequestModel hackathonDetailsRequestModel) {
		
		// HackathonDetailsRequestModel object: contains input request data
		
		// response model to send data to UI
		HackathonDetailsResposeModel returnModel = new HackathonDetailsResposeModel();
			
		// DTO object to hold the input request data
		HackathonDto hackathonDto = new HackathonDto();
		// transferring input data to DTO object
		ModelMapper mapper = new ModelMapper();
		hackathonDto = mapper.map(hackathonDetailsRequestModel, HackathonDto.class);
		
		// Service method Call to update data
		HackathonDto updatedHackthon = hackathonService.updateHackathon(id, hackathonDto);
		// Transferring DTO object data to response model
		mapper = new ModelMapper();
		returnModel = mapper.map(updatedHackthon, HackathonDetailsResposeModel.class);
					
		return returnModel;
	}
	
	// delete any hackathon
	@DeleteMapping(path="/{id}")
	public String deleteHackathon() {
		return "delete hackathon method was called";
	}
	
}
