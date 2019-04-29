package com.openHack.shared.dto;

import com.openHack.embeddedEntity.Address;

public class OrganizationDto {
	private long id;
	private String name;
	private long ownerId;
	private String description;
	private Address address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "OrganizationDto [name=" + name + ", ownerId=" + ownerId + ", description=" + description + ", address="
				+ address + "]";
	}
	
}
