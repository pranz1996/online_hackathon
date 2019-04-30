package com.openHack.io.entity;

import javax.persistence.*;
import java.io.Serializable;

public class TeamEntity implements Serializable{

	private static final long serialVersionUID = -2974038348995949230L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private long hId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int size;

	@Column(nullable = false)
	private long leaderId;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long gethId() {
		return hId;
	}

	public void sethId(long hId) {
		this.hId = hId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(long leaderId) {
		this.leaderId = leaderId;
	}
	
}
