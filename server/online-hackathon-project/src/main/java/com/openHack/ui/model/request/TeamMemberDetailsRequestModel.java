package com.openHack.ui.model.request;

public class TeamMemberDetailsRequestModel {

	private long tId;
	private String role;
	private boolean paid;
	private long uId;

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}



	@Override
	public String toString() {
		return "TeamMemberDetailsRequestModel [tId=" + tId + ", role=" + role + ", paid=" + paid
				+ ", uId=" + uId + "]";
	}
	
}
