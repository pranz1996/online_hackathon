package com.openHack.shared.dto;

import com.openHack.io.entity.UserEntity;

public class TeamMemberDto {
	private long id;
	private UserEntity userEntity;
	private String role;
	private long hackathonId;
	private boolean paid;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getHackathonId() {
		return hackathonId;
	}
	public void setHackathonId(long hackathonId) {
		this.hackathonId = hackathonId;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
}
