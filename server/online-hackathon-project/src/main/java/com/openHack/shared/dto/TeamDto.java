package com.openHack.shared.dto;

import java.util.List;

public class TeamDto {
	
	private long id;
	private long hackathonId;
	private String teamName;
	private String teamSize;
	private String userId;
	private List<TeamMemberDto> teamMembers;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getHackathonId() {
		return hackathonId;
	}
	public void setHackathonId(long hackathonId) {
		this.hackathonId = hackathonId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<TeamMemberDto> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<TeamMemberDto> teamMembers) {
		this.teamMembers = teamMembers;
	}
	@Override
	public String toString() {
		return "TeamDto [id=" + id + ", hackathonId=" + hackathonId + ", teamName=" + teamName + ", teamSize="
				+ teamSize + ", userId=" + userId + ", teamMembers=" + teamMembers + "]";
	}

	
}
