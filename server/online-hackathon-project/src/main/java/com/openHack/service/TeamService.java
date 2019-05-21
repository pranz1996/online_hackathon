package com.openHack.service;

import java.util.ArrayList;

import javax.json.JsonObject;

import com.openHack.io.entity.TeamMemberEntity;
import com.openHack.io.entity.TeamMembersTeam;
import com.openHack.shared.dto.TeamDto;
import com.openHack.shared.dto.TeamsByJudgeDto;
import com.openHack.ui.model.request.GetTeamIdRequestModel;
import com.openHack.ui.model.request.GradeTeamsRequestModel;
import com.openHack.ui.model.request.SubmissionDetailsRequestModel;
import com.openHack.ui.model.response.TeamDetailsResposeModel;

public interface TeamService {
	TeamDto createTeam(TeamDto teamDto);
	TeamDto getTeamById(long id);
	ArrayList<TeamsByJudgeDto> getTeamByJudge(long id);
	TeamDto updateTeam(long id, TeamDto teamDto);
	void createSubmission(long id, SubmissionDetailsRequestModel submission);
	void createPayment(long id);
	void gradeTeam(long id, double grade);
	void gradeTeamWithName(GradeTeamsRequestModel gradeTeam);
	JsonObject getTeamId(GetTeamIdRequestModel getTeamId);
	ArrayList<TeamDto> getTeamsForEvaluation(long id);
}
