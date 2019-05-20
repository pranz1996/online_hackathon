package com.openHack.ui.model.response;

public class TeamMemberDetailsResposeModel {
	private long id;
	private long userId;
	private String role;
	private boolean paid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
		return "TeamMemberDetailsResposeModel [id=" + id + ", userId=" + userId + ", role=" + role + ", paid=" + paid
				+ "]";
	}	
}
