package com.openHack.ui.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDetailsResposeModel {
	
	private long id;
	private long hackathonId;
	private String teamName;
	private String teamSize;
	private long userId;
	private String submissionLink;
	
	private List<TeamMemberDetailsResposeModel> teamMembers;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public List<TeamMemberDetailsResposeModel> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<TeamMemberDetailsResposeModel> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public String getSubmissionLink() {
		return submissionLink;
	}
	public void setSubmissionLink(String submissionLink) {
		this.submissionLink = submissionLink;
	}
	@Override
	public String toString() {
		return "TeamDetailsResposeModel [id=" + id + ", hackathonId=" + hackathonId + ", teamName=" + teamName
				+ ", teamSize=" + teamSize + ", userId=" + userId + ", submissionLink=" + submissionLink
				+ ", teamMembers=" + teamMembers + "]";
	}
	
}
