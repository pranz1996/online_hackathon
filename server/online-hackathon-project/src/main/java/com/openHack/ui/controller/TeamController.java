package com.openHack.ui.controller;

import com.openHack.service.TeamService;
import com.openHack.shared.dto.TeamDto;
import com.openHack.ui.model.request.TeamDetailsRequestModel;
import com.openHack.ui.model.response.TeamDetailsResposeModel;
import org.springframework.beans.BeanUtils;
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

    	// response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();
    	
        // TeamDetailsRequestModel object: contains input request data
    	
       
//        // DTO object to hold the input request data
//        TeamDto teamDto = new TeamDto();
//        // transferring input data to DTO object
//        BeanUtils.copyProperties(teamDetailsRequestModel, teamDto);
//
//        // Service method Call to insert data
//        TeamDto createTeam = teamService.createTeam(teamDto);
//        // Transferring DTO object data to response model
//        BeanUtils.copyProperties(createTeam, returnModel);

        return returnModel;
    }

    // get any team by id
    @GetMapping(path="/{id}")
    public TeamDetailsResposeModel getTeam(@PathVariable long id) {

        // response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();

//        // Service method Call to get team data based on id
//        TeamDto teamDetails = teamService.getTeamById(id);
//        // transferring DTO object data to response model
//        BeanUtils.copyProperties(teamDetails, returnModel);

        return returnModel;
    }

    // get all the teams
    @GetMapping
    public String getTeams() {
        return "get all teams method was called";
    }


    // update any Team details
    @PutMapping(path="/{id}")
    public TeamDetailsResposeModel updateTeam(@PathVariable long id, @RequestBody TeamDetailsRequestModel teamDetailsRequestModel) {

        // TeamDetailsRequestModel object: contains input request data

        // response model to send data to UI
        TeamDetailsResposeModel returnModel = new TeamDetailsResposeModel();

//        // DTO object to hold the input request data
//        TeamDto teamDto = new TeamDto();
//        // transferring input data to DTO object
//        BeanUtils.copyProperties(teamDetailsRequestModel, teamDto);
//
//        // Service method Call to update data
//        TeamDto updatedTeam = teamService.updateTeam(id, teamDto);
//        // Transferring DTO object data to response model
//        BeanUtils.copyProperties(updatedTeam, returnModel);

        return returnModel;
    }

    // delete any team
    @DeleteMapping(path="/{id}")
    public String deleteTeam() {
        return "delete team method was called";
    }
}
