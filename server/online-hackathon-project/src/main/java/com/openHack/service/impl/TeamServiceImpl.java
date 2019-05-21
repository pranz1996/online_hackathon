package com.openHack.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.io.entity.HackathonEntity;
import com.openHack.io.entity.TeamEntity;
import com.openHack.io.entity.TeamMemberEntity;
import com.openHack.io.entity.TeamMembersTeam;
import com.openHack.io.entity.UserEntity;
import com.openHack.io.repository.HackathonRepository;
import com.openHack.io.repository.TeamMemberRepository;
import com.openHack.io.repository.TeamMembersTeamRepository;
import com.openHack.io.repository.TeamRepository;
import com.openHack.io.repository.UserRepository;
import com.openHack.service.TeamService;
import com.openHack.shared.dto.HackathonDto;
import com.openHack.shared.dto.TeamDto;
import com.openHack.shared.dto.TeamMemberDto;
import com.openHack.shared.dto.TeamsByJudgeDto;
import com.openHack.ui.model.request.GetTeamIdRequestModel;
import com.openHack.ui.model.request.GradeTeamsRequestModel;
import com.openHack.ui.model.request.SubmissionDetailsRequestModel;
import com.openHack.ui.model.request.TeamDetailsRequestModel;
import com.openHack.ui.model.response.TeamDetailsResposeModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import org.hibernate.sql.Template;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	TeamMemberRepository teamMemberRepository;
	
	@Autowired
	HackathonRepository hackathonRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TeamMembersTeamRepository teamMembersTeamRepository;
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
		
		List<TeamMemberEntity> teamMembers = savedTeam.getTeamMembers();
		
		// creating list of team member to send email after registration for hackathon
		List<String> listOfTeamMembers = new ArrayList<>();
		
		for(int i = 0; i < teamMembers.size(); i++) {
			long memberId = teamMembers.get(i).getUserId();
			UserEntity member = userRepository.findById(memberId);
			listOfTeamMembers.add(member.getEmail());
		}
		System.out.println(" List of team member to send email :" + listOfTeamMembers);
		
		System.out.println(" email confirmation ... ");
		
		long teamId = savedTeam.getId();
		
		TeamMembersTeam t = null;
		
		for(int i = 0; i < teamMembers.size(); i++) {
			t = new TeamMembersTeam();
			t.setTeamId(teamId); 	t.setMemberId(teamMembers.get(i).getId());
			teamMembersTeamRepository.save(t);
		}
		
		
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

	// method for submission for any team based on team id
	public void createSubmission(long id, SubmissionDetailsRequestModel submission) {
		
		// Fetch team entity based on team id
		TeamEntity teamEntity = teamRepository.findById(id);
		
		// updating submission field
		teamEntity.setSubmissionLink(submission.getSubmission_link());
		
		// Saving the updated Team Entity
		teamRepository.save(teamEntity);
	
	}

	// method for payment by any team member
	@Override
	public void createPayment(long id) {
		
		// Fetch TeamMember details
		TeamMemberEntity teamMemberEntity = teamMemberRepository.findById(id);
		
		// updating payment field
		teamMemberEntity.setPaid(true);
		
		// Saving the updated TeamMebmer Details
		teamMemberRepository.save(teamMemberEntity);
	}

    //judges user id
	@Override
	public ArrayList<TeamsByJudgeDto> getTeamByJudge(long id) 
	{
		//things we need
		//teamName, submissionLink, hackathonStatus, hackathonName
		ArrayList<TeamsByJudgeDto> responseDtoArray = new ArrayList<TeamsByJudgeDto>();
		TeamsByJudgeDto responseDto;
		ArrayList<Long> hackthon_ids = new ArrayList<Long>();
		HackathonEntity hackEnt;
		ArrayList<TeamEntity> teamEntities;
		ArrayList<String> teamWithSubmissionLinks;
		
		hackthon_ids = hackathonRepository.getHackathonIds(id);
		
		Iterator it = hackthon_ids.iterator();
		
		while(it.hasNext())
		{
			responseDto = new TeamsByJudgeDto();
			hackEnt = new HackathonEntity();
			hackEnt = hackathonRepository.findById(((Long) it.next()).longValue());
			responseDto.setHackathonName(hackEnt.getEventName());
			responseDto.setHackathonStatus(hackEnt.getStatus());
			teamEntities = new ArrayList<TeamEntity>();
			teamEntities = teamRepository.getTeamsByHackathonId(hackEnt.getId());
			
			teamWithSubmissionLinks = new ArrayList<String>();
			for (TeamEntity element : teamEntities) 
			{
				String val = element.getTeamName() + " ";
				if (element.getSubmissionLink() != null)
				{
					val = val + element.getSubmissionLink();
				}
				else
				{
					val = val + "No-submission";
				}
				teamWithSubmissionLinks.add(val);
			}		
			responseDto.setTeamWithSubmissionLinks(teamWithSubmissionLinks);
			responseDtoArray.add(responseDto);
		}
		return responseDtoArray;
	}


	@Override
	public void gradeTeam(long id, double grade) {
		teamRepository.gradeTeam(grade, id);
	}


	@Override
	public void gradeTeamWithName(GradeTeamsRequestModel gradeTeam) {
		HackathonEntity hackEnt = new HackathonEntity();
		hackEnt = hackathonRepository.findByEventName(gradeTeam.getHackathonName());
		
		teamRepository.gradeTeam(gradeTeam.getGrade(), gradeTeam.getTeamName(),hackEnt.getId());
	}

	@Override
	public JsonObject getTeamId(GetTeamIdRequestModel getTeamId) {
		
		TeamMemberEntity teamMember = teamMemberRepository.findHackathonByUser(getTeamId.getUserId(), getTeamId.getHackathonId());
		
		long id = teamMember.getId();
		
		TeamMembersTeam teamId = teamMembersTeamRepository.findMemberId(id);
		
		HackathonEntity hackathon =  hackathonRepository.findById(teamMember.getHackathonId());
		
		
		JsonObject object = Json.createObjectBuilder()
				.add("status", hackathon.getStatus())
				.add("team_id", String.valueOf(teamId.getTeamId()))
				.build();
		
		return object;	
	}

	@Override
	public ArrayList<TeamDto> getTeamsForEvaluation(long id) {
		
		ArrayList<TeamEntity> allTeams = teamRepository.getTeamsByHackathonId(id); 
		
		ArrayList<TeamDto> allTeamsDto = new ArrayList<>();
		
		Iterator iterator = allTeams.iterator();
		
		while(iterator.hasNext())
		{
			TeamDto team = new TeamDto();
			BeanUtils.copyProperties(iterator.next(), team);
			allTeamsDto.add(team);
		}
		
		return allTeamsDto;
	}
}
