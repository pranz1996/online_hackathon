package com.openHack.ui.model.request;

import com.openHack.io.entity.UserEntity;

public class TeamMemberDetailsRequestModel {

	private String role;
	private long hackathonId;
	private boolean paid = false;
	private UserEntity userEntity;
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
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
	@Override
	public String toString() {
		return "TeamMemberDetailsRequestModel [role=" + role + ", hackathonId=" + hackathonId + ", paid=" + paid
				+ ", userEntity=" + userEntity + "]";
	}
	
	
}
