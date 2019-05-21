package com.openHack.ui.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openHack.io.entity.HackathonEntity;
import com.openHack.service.HackathonService;
import com.openHack.shared.dto.HackathonDto;
//import com.openHack.shared.dto.HackathonResultsDto;
import com.openHack.ui.model.request.HackathonDetailsRequestModel;
import com.openHack.ui.model.request.JoinRequestDetailsModel;
import com.openHack.ui.model.response.HackathonDetailsResposeModel;
import com.openHack.ui.model.response.UserDetailsResponseModel;
//import com.openHack.ui.model.response.hackathonResultsResponseModel;


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
	@RequestMapping(value = "/getAllHackathons", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public ArrayList<HackathonDetailsResposeModel> getAllHackathons() 
	{	
		ArrayList<HackathonDetailsResposeModel> listOfHackathons = new ArrayList<HackathonDetailsResposeModel>();
		HackathonDetailsResposeModel singleResponseModel;
		ArrayList<HackathonDto> hackathonDtoList = new ArrayList<HackathonDto>();
		
		hackathonDtoList = hackathonService.getAllHackathon();
		Iterator dtoIterator = hackathonDtoList.iterator(); 
		
		while(dtoIterator.hasNext())
		{
			singleResponseModel = new HackathonDetailsResposeModel();
			BeanUtils.copyProperties(dtoIterator.next(), singleResponseModel);
			if(singleResponseModel.getStatus().equals("created"))
				singleResponseModel.setStatus(" start the hackathon");
			else if(singleResponseModel.getStatus().equals("start"))
				singleResponseModel.setStatus(" close the hackathon");
			else if(singleResponseModel.getStatus().equals("closed"))
				singleResponseModel.setStatus(" Finalize the hackathon");
			listOfHackathons.add(singleResponseModel);
		}
		return listOfHackathons;
	}
	
	// create and add new hackathon
	@PostMapping
	public HackathonDetailsResposeModel createHackathon(@RequestBody HackathonDetailsRequestModel hackathonDetailsRequestModel) {
		
		System.out.println("P" + hackathonDetailsRequestModel);
		
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
	
	@PutMapping(path="updateStatus/{id}")
	public HackathonDetailsResposeModel updateHackathonStatus(@PathVariable long id) {
		
		HackathonDetailsResposeModel returnModel = new HackathonDetailsResposeModel();
							
		HackathonDto hackathonDetails = hackathonService.updateStatus(id);
				
		ModelMapper mapper = new ModelMapper();
		returnModel = mapper.map(hackathonDetails, HackathonDetailsResposeModel.class);
				
		return returnModel;
		
	}
	
//	@GetMapping(path="hackathonResults/{name}")
//	public HackathonResultsDto getHackathonResults(@PathVariable String name) {
//		
//		HackathonResultsDto results = new HackathonResultsDto();
//				
//		
//		return results;
//		
//	}
	
	
//	@RequestMapping(value = "/joinHackathon", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
//	public String joinHackathon(@RequestBody JoinRequestDetailsModel joinRequestDetailsModel) {
//		
//	
//		HackathonDetailsResposeModel returnModel = new HackathonDetailsResposeModel();
//		
//		// DTO object to hold the input request data
//		HackathonDto hackathonDto = new HackathonDto();
//		// transferring input data to DTO object
//		ModelMapper mapper = new ModelMapper();
//		hackathonDto = mapper.map(hackathonDetailsRequestModel, HackathonDto.class);
//		System.out.println(hackathonDto);
//		// Service method Call to insert data
//		HackathonDto createHacathon = hackathonService.createHackthon(hackathonDto);
//		// Transferring DTO object data to response model
//		mapper = new ModelMapper();
//		returnModel = mapper.map(createHacathon, HackathonDetailsResposeModel.class);
//	
//		return returnModel;
//	}
	
	
}
