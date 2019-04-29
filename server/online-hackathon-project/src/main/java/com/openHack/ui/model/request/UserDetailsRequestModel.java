package com.openHack.ui.model.request;

import com.openHack.embeddedEntity.Address;

public class UserDetailsRequestModel {
	private String userName;
	private String email;
	private String password;
	private String portraitUrl;
	private String title;
	private String about;
	private Address address;
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
	
	@Override
	public String toString() {
		return "UserDetailsRequestModel [userName=" + userName + ", email=" + email + ", password=" + password
				+ ", portraitUrl=" + portraitUrl + ", title=" + title + ", about=" + about + ", address=" + address
				+ "]";
	}
}

