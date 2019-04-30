package com.openHack.service.impl;

import com.openHack.io.entity.TeamEntity;
import com.openHack.io.repository.TeamRepository;
import com.openHack.service.TeamService;
import com.openHack.shared.dto.TeamDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

//	@Autowired
//	TeamRepository teamRepository;
	
	// Service method store team object to database
//	@Override
//	public TeamDto createTeam(TeamDto teamDto) {
//		
//		// returning the saved object to UI
//		TeamDto returnValue = new TeamDto();
//		
//		// DTO object to Entity object transfer
//		TeamEntity teamEntity = new TeamEntity();
////		BeanUtils.copyProperties(teamDto, teamEntity);
////		
////		// Repository method (save) to save TeamEntity object to table teams
////		TeamEntity teamEntityDetails = teamRepository.save(teamEntity);
////		
//
////		BeanUtils.copyProperties(teamEntityDetails, returnValue);
//		
//		return returnValue;
//	}
//
//	// Service method to get any hackathon based on it's id(primary key)
//	@Override
//	public TeamDto getTeamById(long id) {
//		
//		// returning object to UI
//		TeamDto returnValue = new TeamDto();
//		
////		// Repository method (findById()) to fetch team details
////		TeamEntity teamEntity = teamRepository.findById(id);
////		
//// 		// Entity object to DTO object transfer
////		BeanUtils.copyProperties(teamEntity, returnValue);
////		
//		return returnValue;
//	}
//
//	@Override
//	public TeamDto updateTeam(long id, TeamDto teamDto) {
//	
//		// returning object to UI
//		TeamDto returnValue = new TeamDto();
//		
////		// Repository method (findById()) to fetch hackathon details
////		TeamEntity teamEntity = teamRepository.findById(id);
////		
////		// updating the fields for teamEntity
////		teamEntity.sethId(teamDto.gethId());
////		teamEntity.setName(teamDto.getName());
////		teamEntity.setSize(teamDto.getSize());
////		teamEntity.setLeaderId(teamDto.getLeaderId());
////		
////		// Repository method (save) to save updated TeamEntity object to table hackathons
////		TeamEntity updateTeam = teamRepository.save(teamEntity);
////		BeanUtils.copyProperties(updateTeam, returnValue);
//	
//		return returnValue;
//	}

}
