package com.openHack.service.impl;

import com.openHack.io.entity.TeamMemberEntity;
import com.openHack.io.repository.TeamMemberRepository;
import com.openHack.service.TeamMemberService;
import com.openHack.shared.dto.TeamMemberDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

	@Autowired
	TeamMemberRepository teamMemberRepository;
	
	// Service method store team object to database
	@Override
	public TeamMemberDto createTeamMember(TeamMemberDto teamMemberDto) {
		
		// DTO object to Entity object transfer
		TeamMemberEntity teamMemberEntity = new TeamMemberEntity();
		BeanUtils.copyProperties(teamMemberDto, teamMemberEntity);
		
		// Repository method (save) to save TeamEntity object to table teams
		TeamMemberEntity teamMemberEntityDetails = teamMemberRepository.save(teamMemberEntity);
		
		// returning the saved object to UI
		TeamMemberDto returnValue = new TeamMemberDto();
		BeanUtils.copyProperties(teamMemberEntityDetails, returnValue);
		
		return returnValue;
	}

	// Service method to get any team member based on it's id(primary key)
	@Override
	public TeamMemberDto getTeamMemberById(long id) {
		
		// returning object to UI
		TeamMemberDto returnValue = new TeamMemberDto();
		
		// Repository method (findById()) to fetch team details
		TeamMemberEntity teamMemberEntity = teamMemberRepository.findById(id);
		
 		// Entity object to DTO object transfer
		BeanUtils.copyProperties(teamMemberEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public TeamMemberDto updateTeamMember(long id, TeamMemberDto teamDto) {
	
		// returning object to UI
		TeamMemberDto returnValue = new TeamMemberDto();
		
		// Repository method (findById()) to fetch hackathon details
		TeamMemberEntity teamMemberEntity = teamMemberRepository.findById(id);
		
		// updating the fields for teamMemberEntity
		teamMemberEntity.settId(teamDto.gettId());
		teamMemberEntity.setRole(teamDto.getRole());
		teamMemberEntity.setPaid(teamDto.getPaid());
		teamMemberEntity.setuId(teamDto.getuId());
		
		// Repository method (save) to save updated TeamEntity object to table hackathons
		TeamMemberEntity updateTeam = teamMemberRepository.save(teamMemberEntity);
		BeanUtils.copyProperties(updateTeam, returnValue);
	
		return returnValue;
	}

}
