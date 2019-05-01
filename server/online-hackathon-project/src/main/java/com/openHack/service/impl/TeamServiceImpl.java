package com.openHack.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.io.entity.TeamEntity;
import com.openHack.io.entity.TeamMemberEntity;
import com.openHack.io.repository.TeamMemberRepository;
import com.openHack.io.repository.TeamRepository;
import com.openHack.service.TeamService;
import com.openHack.shared.dto.TeamDto;
import com.openHack.shared.dto.TeamMemberDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	TeamMemberRepository teamMemberRepository;

	// service method to store team details
	@Override
	public TeamDto createTeam(TeamDto teamDto) {
		
		// returning the saved object to UI
		TeamDto returnValue = new TeamDto();
		
		TeamEntity teamEntity = new TeamEntity();
	
		// DTO object to Entity object to store into table
		ObjectMapper mapper = new ObjectMapper();
		teamEntity = mapper.convertValue(teamDto, TeamEntity.class);
		
		// Repository method to save TeamEntity
		TeamEntity savedTeam = teamRepository.save(teamEntity);
		
		mapper = new ObjectMapper();
		// Returning saved entity to Response Model
		returnValue = mapper.convertValue(savedTeam, TeamDto.class);

		return returnValue;
	}
	

	// Service method to get any team based on it's id(primary key)
	@Override
	public TeamDto getTeamById(long id) {
		
		// returning object to UI
		TeamDto returnValue = new TeamDto();
		
		// Repository method (findById()) to fetch team details
		TeamEntity teamEntity = teamRepository.findById(id);
		
 		// Entity object to DTO object transfer
		ObjectMapper mapper = new ObjectMapper();
		returnValue = mapper.convertValue(teamEntity, TeamDto.class);
	
		return returnValue;
	}
	
	@Override
	public TeamDto updateTeam(long id, TeamDto teamDto) {
	
		// returning object to UI
		TeamDto returnValue = new TeamDto();
		
		// Repository method (findById()) to fetch team details
		TeamEntity teamEntity = teamRepository.findById(id);
		
		// Updating the Fields : start
	
		// updating the fields for teamEntity
		teamEntity.setTeamName(teamDto.getTeamName());
		teamEntity.setTeamSize(teamDto.getTeamSize());
		
		// updating child attributes
		// OLD teamMember details
		List<TeamMemberEntity> teamMemberEntity = teamEntity.getTeamMembers();
		// NEW teamMember details
		List<TeamMemberDto> teamMembers = teamDto.getTeamMembers();
		
		List<TeamMemberEntity> updatedTeamMembers = new ArrayList<>();
	
		ObjectMapper mapper = new ObjectMapper();
		for(int i = 0; i < teamMembers.size(); i++) {
			TeamMemberEntity teamMember = mapper.convertValue(teamMembers.get(i), TeamMemberEntity.class);
			updatedTeamMembers.add(teamMember);
		}
		// deleting OLD teamMember details
		teamMemberRepository.deleteAllById(id);
		// adding NEW teamMember details
		teamMemberEntity = new ArrayList<>(updatedTeamMembers);
		
		teamEntity.setTeamMembers(teamMemberEntity);
	
		// Updating the Fields : end
		
		// Saving updated TeamEntity object
		TeamEntity updatedTeam = teamRepository.save(teamEntity);
		
		// returning response model
		BeanUtils.copyProperties(updatedTeam, returnValue);
	
		return returnValue;
	}

}
