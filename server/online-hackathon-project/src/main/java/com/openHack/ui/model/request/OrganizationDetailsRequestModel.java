package com.openHack.ui.model.request;

import com.openHack.embeddedEntity.Address;


public class OrganizationDetailsRequestModel {
	private String name;
	private long ownerId;
	private String description;
	private Address address;
	private boolean adminCheck = false;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.toLowerCase();
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "OrganizationDetailsRequestModel [name=" + name + ", ownerId=" + ownerId + ", description=" + description
				+ ", address=" + address + ", adminCheck=" + adminCheck + "]";
	}
	

}
