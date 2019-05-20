package com.openHack.ui.model.request;

public class TeamMemberDetailsRequestModel {

	private long userId;
	private String role = "programmer";
	private boolean paid = false;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	@Override
	public String toString() {
		return "TeamMemberDetailsRequestModel [userId=" + userId + ", role=" + role + ", paid=" + paid + "]";
	}
	
	
	
}
