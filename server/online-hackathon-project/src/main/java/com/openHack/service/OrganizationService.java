package com.openHack.service;

import java.util.ArrayList;

import com.openHack.shared.dto.OrganizationDto;

public interface OrganizationService {
	OrganizationDto createOrganization(OrganizationDto organizationDto);
	OrganizationDto getOrganizationById(long id);
	OrganizationDto updateOrganization(long id, OrganizationDto organizationDto);
	ArrayList<OrganizationDto> getAllOrganisations();
	OrganizationDto getMyOrganisations(long id);
	void leaveOrganisation(long id);
}
