package com.openHack.shared.dto;

public class TeamDto {
	private long id;
	private long hId;
	private String name;
	private int size;
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



	@Override
	public String toString() {
		return "TeamDto [hId=" + hId + ", name=" + name + ", size=" + size
				+ ", leaderId=" + leaderId + "]";
	}
	

}
