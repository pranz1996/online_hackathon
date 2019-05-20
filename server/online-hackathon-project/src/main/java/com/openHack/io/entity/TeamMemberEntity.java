package com.openHack.io.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "teamMembers")
public class TeamMemberEntity implements Serializable{

	private static final long serialVersionUID = -2974038348995949230L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private long userId;

	@Column(nullable = false) 
	private String role;

	@Column(nullable = false)
	private boolean paid;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TeamMemberEntity [id=" + id + ", userId=" + userId + ", role=" + role + ", paid=" + paid + "]";
	}

}
