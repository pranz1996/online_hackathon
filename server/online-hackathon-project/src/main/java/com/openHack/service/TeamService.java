package com.openHack.service;

import java.util.ArrayList;

import com.openHack.shared.dto.TeamDto;
import com.openHack.shared.dto.TeamsByJudgeDto;
import com.openHack.ui.model.request.GradeTeamsRequestModel;
import com.openHack.ui.model.request.SubmissionDetailsRequestModel;

public interface TeamService {
	TeamDto createTeam(TeamDto teamDto);
	TeamDto getTeamById(long id);
	ArrayList<TeamsByJudgeDto> getTeamByJudge(long id);
	TeamDto updateTeam(long id, TeamDto teamDto);
	void createSubmission(long id, SubmissionDetailsRequestModel submission);
	void createPayment(long id);
	void gradeTeam(long id, double grade);
	void gradeTeamWithName(GradeTeamsRequestModel gradeTeam);
}
