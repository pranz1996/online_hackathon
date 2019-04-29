package com.openHack.io.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.openHack.embeddedEntity.Address;
import com.openHack.io.entity.OrganizationEntity;

@Entity(name = "users")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1464447855335313510L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String password;
	
	private String portraitUrl;
	
	@OneToOne(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE ,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="organizationId")
	private OrganizationEntity organizationEntity;
	
	private String title; // business title
	
	private String about;
	
	@Column(columnDefinition = "boolean default false")
	private boolean adminCheck;
	
	@Column
	@Embedded
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="organization_join_request", joinColumns = @JoinColumn(name="user_id"), 
												 inverseJoinColumns = @JoinColumn(name="organization_id"))
	private List<OrganizationEntity> organizations;
	
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
	
	public OrganizationEntity getOrganizationEntity() {
		return organizationEntity;
	}

	public void setOrganizationEntity(OrganizationEntity organizationEntity) {
		this.organizationEntity = organizationEntity;
	}

	public boolean isAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(boolean adminCheck) {
		this.adminCheck = adminCheck;
	}
	
	public List<OrganizationEntity> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationEntity> organizations) {
		this.organizations = organizations;
	}

	public void addOrganization(OrganizationEntity organizationEntity) {
		if(organizations == null)
			organizations = new ArrayList<>();
		
		organizations.add(organizationEntity);
	}
	
	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", email=" + email + ", password=" + password + ", portraitUrl="
				+ portraitUrl + ", organizationEntity=" + organizationEntity + ", title=" + title + ", about=" + about
				+ ", address=" + address + "]";
	}
	
	
}
