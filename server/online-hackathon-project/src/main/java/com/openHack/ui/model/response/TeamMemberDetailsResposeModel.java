package com.openHack.ui.model.response;

public class TeamMemberDetailsResposeModel {
	private long id;
	private String userId;
	private String role;
	private boolean paid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
		return "TeamMemberDetailsResposeModel [id=" + id + ", userId=" + userId + ", role=" + role + ", paid=" + paid
				+ "]";
	}
	
}
