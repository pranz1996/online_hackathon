package com.openHack.ui.model.response;

public class TeamMemberDetailsResposeModel {
	private long id;
	private long tId;
	private String role;
	private boolean paid;
	private long uId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
		return "TeamMemberDetailsResposeModel [tId=" + tId + ", role=" + role + ", paid=" + paid
				+ ", uId=" + uId + "]";
	}

	
	
}
