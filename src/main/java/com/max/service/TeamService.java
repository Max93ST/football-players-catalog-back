package com.max.service;

import com.max.model.dto.TeamDTO;

import java.util.List;

public interface TeamService {

    TeamDTO createTeam(TeamDTO team);

    List<TeamDTO> getTeamList();
}
