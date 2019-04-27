package com.openHack.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="hackathons")
public class HackathonEntity implements Serializable{

	private static final long serialVersionUID = -2974038348995949230L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String eventName;
	
	@Column(nullable = false, length = 10)
	private String description;
	
	@Column(nullable = false)
	private String fee;
	
	@Column(nullable = false)
	private String minTeamSize;
	
	@Column(nullable = false)
	private String maxTeamSize;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getMinTeamSize() {
		return minTeamSize;
	}

	public void setMinTeamSize(String minTeamSize) {
		this.minTeamSize = minTeamSize;
	}

	public String getMaxTeamSize() {
		return maxTeamSize;
	}

	public void setMaxTeamSize(String maxTeamSize) {
		this.maxTeamSize = maxTeamSize;
	}
	
}
