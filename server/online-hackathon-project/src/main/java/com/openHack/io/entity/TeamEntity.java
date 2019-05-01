package com.openHack.io.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "teams")
public class TeamEntity implements Serializable{

	private static final long serialVersionUID = -2974038348995949230L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private long hackathonId;
	
	@Column(nullable = false)
	private String teamName;
	
	@Column(nullable = false)
	private String teamSize;
	
	@Column(nullable = false)
	private String userId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	private List<TeamMemberEntity> teamMembers;

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

	public List<TeamMemberEntity> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<TeamMemberEntity> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	public void addTeamMember(TeamMemberEntity teamMember) {
		if(teamMembers == null)
			teamMembers = new ArrayList<>();
		teamMembers.add(teamMember);
	}

	@Override
	public String toString() {
		return "TeamEntity [id=" + id + ", hackathonId=" + hackathonId + ", teamName=" + teamName + ", teamSize="
				+ teamSize + ", userId=" + userId + ", teamMembers=" + teamMembers + "]";
	}
	
}
