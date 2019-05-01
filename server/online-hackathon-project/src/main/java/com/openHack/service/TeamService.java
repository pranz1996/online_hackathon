package com.openHack.service;

import com.openHack.shared.dto.TeamDto;

public interface TeamService {
	TeamDto createTeam(TeamDto teamDto);
	TeamDto getTeamById(long id);
	TeamDto updateTeam(long id, TeamDto teamDto);
}
