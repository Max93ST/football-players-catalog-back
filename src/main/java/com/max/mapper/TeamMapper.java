package com.max.mapper;

import com.max.model.dto.TeamDTO;
import com.max.model.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team teamDTOToTeam(TeamDTO teamDTO);

    TeamDTO teamToTeamDTO(Team team);
}
