package com.openHack.ui.model.response;

import com.openHack.embeddedEntity.Address;

public class UserDetailsResponseModel {
	private long id;
	private String userName;
	private String email;
	private String portraitUrl;
	private String title; // business title
	private String about;
	private Address address;
	private boolean isEmailVerfied;
	
	public boolean isEmailVerfied() {
		return isEmailVerfied;
	}
	public void setEmailVerfied(boolean isEmailVerfied) {
		this.isEmailVerfied = isEmailVerfied;
	}
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
	
	@Override
	public String toString() {
		return "UserDetailsResponseModel [userName=" + userName + ", email=" + email + ", portraitUrl=" + portraitUrl
				+ ", title=" + title + ", about=" + about + ", address=" + address + "]";
	}
	
}


