package com.openHack.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="teams")
public class TeamMemberEntity implements Serializable{

	private static final long serialVersionUID = -2974038348995949230L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private long tId;

	@Column(nullable = false)
	private String role;

	@Column(nullable = false)
	private boolean paid;

	@Column(nullable = false)
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
	
}
