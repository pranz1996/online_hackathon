package com.openHack.ui.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.service.TeamService;
import com.openHack.shared.dto.TeamDto;
import com.openHack.ui.model.request.SubmissionDetailsRequestModel;
import com.openHack.ui.model.request.TeamDetailsRequestModel;
import com.openHack.ui.model.response.TeamDetailsResposeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teams") // -> http://localhost:8080/teams
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
    TeamService teamService;
    
    // create and add new Team
    @PostMapping
    public TeamDetailsResposeModel createTeam(@RequestBody TeamDetailsRequestModel teamDetailsRequestModel) {

    	// TeamDetailsRequestModel object: contains input request data
    	
    	// response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();
    	
        // DTO object to hold the input request data
        TeamDto teamDto = new TeamDto();
        
        // transferring input data to DTO object matches multiple source property hierarchies:
        ObjectMapper mapper = new ObjectMapper();
        teamDto = mapper.convertValue(teamDetailsRequestModel, TeamDto.class);
        
        // Service method Call to insert data
        TeamDto createTeam = teamService.createTeam(teamDto);
       
        // Transferring DTO object data to response model
        mapper = new ObjectMapper();
        returnModel = mapper.convertValue(createTeam, TeamDetailsResposeModel.class);
           
        return returnModel;
    }

    // get any team by id
    @GetMapping(path="/{id}")
    public TeamDetailsResposeModel getTeam(@PathVariable long id) {

        // response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();

        // Service method Call to get team data based on id
        TeamDto teamDetails = teamService.getTeamById(id);
        
        // transferring DTO object data to response model
        ObjectMapper mapper = new ObjectMapper();
        returnModel = mapper.convertValue(teamDetails, TeamDetailsResposeModel.class);

        return returnModel;
    }

    // update any Team details
    @PutMapping(path="/{id}")
    public TeamDetailsResposeModel updateTeam(@PathVariable long id, @RequestBody TeamDetailsRequestModel teamDetailsRequestModel) {

        // TeamDetailsRequestModel object: contains input request data

        // response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();

        // DTO object to hold the input request data
        TeamDto teamDto = new TeamDto();
        
        // transferring input data to DTO object
        ObjectMapper mapper = new ObjectMapper();
        teamDto = mapper.convertValue(teamDetailsRequestModel, TeamDto.class);
        
        // Service method Call to update data
        TeamDto updatedTeam = teamService.updateTeam(id, teamDto);
        
        // Transferring DTO object data to response model
        mapper = new ObjectMapper();
        returnModel = mapper.convertValue(updatedTeam, TeamDetailsResposeModel.class);

        return returnModel;
    }
    
    // submission for any hackathon by particular team
    @PatchMapping(path = "/submission/{id}") 
    public String sumbission(@PathVariable long id, @RequestBody SubmissionDetailsRequestModel submission) {
    	
    	teamService.createSubmission(id, submission);
    	 	
    	return "you have submitted for hackathon";
    }
    
    // payment by any team member for a hackathon
    @PatchMapping(path="/pay/{id}")
    public String paymentForHackathon(@PathVariable long id) {
    	
    	teamService.createPayment(id);
    	
    	return "successfully pay for the hackathon";
    }
}
