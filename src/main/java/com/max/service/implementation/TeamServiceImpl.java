package com.max.service.implementation;

import com.max.mapper.TeamMapper;
import com.max.model.dto.TeamDTO;
import com.max.repository.TeamRepository;
import com.max.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;
    private final TeamMapper mapper;

    @Override
    @Transactional
    public TeamDTO createTeam(TeamDTO team) {
        return mapper.teamToTeamDTO(repository.save(mapper.teamDTOToTeam(team)));
    }

    @Override
    public List<TeamDTO> getTeamList() {
        return repository.findAll().stream().map(mapper::teamToTeamDTO).toList();
    }
}
