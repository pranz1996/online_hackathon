package com.openHack.shared.dto;

import java.util.List;

import com.openHack.io.entity.UserEntity;

public class HackathonDto {
	private long id;
	private String eventName;
	private String startTime;
	private String endTime;
	private String description;
	private String fee;
	private String minTeamSize;
	private String maxTeamSize;
	private boolean hackatonWinner = false;
	private List<UserEntity> judges;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public List<UserEntity> getJudges() {
		return judges;
	}
	public void setJudges(List<UserEntity> judges) {
		this.judges = judges;
	}
	
	public boolean isHackatonWinner() {
		return hackatonWinner;
	}
	public void setHackatonWinner(boolean hackatonWinner) {
		this.hackatonWinner = hackatonWinner;
	}
	@Override
	public String toString() {
		return "HackathonDto [id=" + id + ", eventName=" + eventName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", description=" + description + ", fee=" + fee + ", minTeamSize=" + minTeamSize
				+ ", maxTeamSize=" + maxTeamSize + ", hackatonWinner=" + hackatonWinner + ", judges=" + judges + "]";
	}

}
