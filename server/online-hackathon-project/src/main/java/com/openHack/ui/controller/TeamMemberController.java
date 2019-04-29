package com.openHack.ui.controller;

import com.openHack.service.TeamMemberService;
import com.openHack.shared.dto.TeamMemberDto;
import com.openHack.ui.model.request.TeamMemberDetailsRequestModel;
import com.openHack.ui.model.response.TeamMemberDetailsResposeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teamMembers") // -> http://localhost:8080/teams
@CrossOrigin(origins = "http://localhost:3000")
public class TeamMemberController {

    @Autowired
    TeamMemberService teamMemberService;

    // get any team member by id
    @GetMapping(path="/{id}")
    public TeamMemberDetailsResposeModel getTeamMember(@PathVariable long id) {

        // response model to send data to UI
        TeamMemberDetailsResposeModel returnModel = new TeamMemberDetailsResposeModel();

        // Service method Call to get team data based on id
        TeamMemberDto teamMemberDetails = teamMemberService.getTeamMemberById(id);
        // transferring DTO object data to response model
        BeanUtils.copyProperties(teamMemberDetails, returnModel);

        return returnModel;
    }

    // get all the team members
    @GetMapping
    public String getTeamMembers() {
        return "get all team members method was called";
    }

    // create and add new Team
    @PostMapping
    public TeamMemberDetailsResposeModel createTeamMember(@RequestBody TeamMemberDetailsRequestModel teamMemberDetailsRequestModel) {

        // TeamDetailsRequestModel object: contains input request data

        // response model to send data to UI
        TeamMemberDetailsResposeModel returnModel = new TeamMemberDetailsResposeModel();

        // DTO object to hold the input request data
        TeamMemberDto teamMemberDto = new TeamMemberDto();
        // transferring input data to DTO object
        BeanUtils.copyProperties(teamMemberDetailsRequestModel, teamMemberDto);

        // Service method Call to insert data
        TeamMemberDto createTeamMember = teamMemberService.createTeamMember(teamMemberDto);
        // Transferring DTO object data to response model
        BeanUtils.copyProperties(createTeamMember, returnModel);

        return returnModel;
    }

    // update any Team details
    @PutMapping(path="/{id}")
    public TeamMemberDetailsResposeModel updateTeamMember(@PathVariable long id, @RequestBody TeamMemberDetailsRequestModel teamMemberDetailsRequestModel) {

        // TeamDetailsRequestModel object: contains input request data

        // response model to send data to UI
        TeamMemberDetailsResposeModel returnModel = new TeamMemberDetailsResposeModel();

        // DTO object to hold the input request data
        TeamMemberDto teamMemberDto = new TeamMemberDto();
        // transferring input data to DTO object
        BeanUtils.copyProperties(teamMemberDetailsRequestModel, teamMemberDto);

        // Service method Call to update data
        TeamMemberDto updatedTeamMember = teamMemberService.updateTeamMember(id, teamMemberDto);
        // Transferring DTO object data to response model
        BeanUtils.copyProperties(updatedTeamMember, returnModel);

        return returnModel;
    }

    // delete any team member
    @DeleteMapping(path="/{id}")
    public String deleteTeamMember() {
        return "delete team member method was called";
    }
}
