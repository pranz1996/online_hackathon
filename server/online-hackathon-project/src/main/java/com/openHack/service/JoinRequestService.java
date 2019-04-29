package com.openHack.service;

import java.util.List;

import com.openHack.io.entity.OrganizationEntity;
import com.openHack.io.entity.UserEntity;
import com.openHack.shared.dto.JoinRequestDto;

public interface JoinRequestService {
	void createRequest(JoinRequestDto joinRequestDto);
	void acceptRequest(JoinRequestDto joinRequestDto);
	List<OrganizationEntity> getOrganizations(long id);
	List<UserEntity> getUsers(long id);
}
