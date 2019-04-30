package com.openHack.ui.model.request;

public class TeamMemberDetailsRequestModel {

	private String userId;
	private String role;
	public String getUser_id() {
		return userId;
	}
	public void setUser_id(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "TeamMemberDetailsRequestModel [userId=" + userId + ", role=" + role + "]";
	}
	
}
