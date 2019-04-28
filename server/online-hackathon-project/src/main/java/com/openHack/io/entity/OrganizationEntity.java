package com.openHack.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.openHack.embeddedEntity.Address;

@Entity(name="organizations")
public class OrganizationEntity implements Serializable{

	private static final long serialVersionUID = 8989459594559579715L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	
	private long owner;
	
	private String description;
	
	@Column
	@Embedded
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

	public long getOwner() {
		return owner;
	}

	public void setOwner(long owner) {
		this.owner = owner;
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
		return "OrganizationEntity [id=" + id + ", name=" + name + ", owner=" + owner + ", description=" + description
				+ ", address=" + address + "]";
	}
	
}
