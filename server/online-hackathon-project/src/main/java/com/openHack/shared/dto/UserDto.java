package com.openHack.shared.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.openHack.embeddedEntity.Address;

@JsonIgnoreProperties(value = {"organizationEntity"})
public class UserDto {

	private long id;
	private String userName;
	private String email;
	private String password;
	private String portraitUrl;
	private String title; // business title
	private String about;
	private Address address;
	private boolean adminCheck = false;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPortraitUrl() {
		return portraitUrl;
	}
	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isAdminCheck() {
		return adminCheck;
	}
	public void setAdminCheck(boolean adminCheck) {
		this.adminCheck = adminCheck;
	}
	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", email=" + email + ", password=" + password + ", portraitUrl="
				+ portraitUrl + ", title=" + title + ", about=" + about + ", address=" + address
				+ "]";
	}
	
}


