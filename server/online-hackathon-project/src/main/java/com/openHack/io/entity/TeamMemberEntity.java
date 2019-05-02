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
	private String role;
	
	@Column(nullable = false)
	private long hackathonId;

	@Column(nullable = false)
	private boolean paid;

	@OneToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	
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
	
	public long getHackathonId() {
		return hackathonId;
	}

	public void setHackathonId(long hackathonId) {
		this.hackathonId = hackathonId;
	}

	@Override
	public String toString() {
		return "TeamMemberEntity [role=" + role + ", hackathonId=" + hackathonId + ", paid=" + paid + ", userEntity="
				+ userEntity + "]";
	}
	
}
