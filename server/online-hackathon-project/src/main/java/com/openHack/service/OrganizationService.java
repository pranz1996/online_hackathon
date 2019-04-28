package com.openHack.service;

import com.openHack.shared.dto.OrganizationDto;

public interface OrganizationService {
	OrganizationDto createOrganization(OrganizationDto organizationDto);
	OrganizationDto getOrganizationById(long id);
	OrganizationDto updateOrganization(long id, OrganizationDto organizationDto);
}
