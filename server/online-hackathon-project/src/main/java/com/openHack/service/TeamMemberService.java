package com.openHack.service;

import com.openHack.shared.dto.TeamMemberDto;

public interface TeamMemberService {
	TeamMemberDto createTeamMember(TeamMemberDto teamMemberDto);
	TeamMemberDto getTeamMemberById(long id);
	TeamMemberDto updateTeamMember(long id, TeamMemberDto teamMemberDto);
}
