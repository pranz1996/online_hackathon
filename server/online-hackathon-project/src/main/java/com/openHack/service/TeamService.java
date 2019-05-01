package com.openHack.service;

import com.openHack.shared.dto.TeamDto;
import com.openHack.ui.model.request.SubmissionDetailsRequestModel;

public interface TeamService {
	TeamDto createTeam(TeamDto teamDto);
	TeamDto getTeamById(long id);
	TeamDto updateTeam(long id, TeamDto teamDto);
	void createSubmission(long id, SubmissionDetailsRequestModel submission);
	void createPayment(long id);
}
