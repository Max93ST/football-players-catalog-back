package com.max.controller;

import com.max.model.dto.TeamDTO;
import com.max.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService service;

    @GetMapping
    public List<TeamDTO> getTeamList() {
        log.info("get team list");
        return service.getTeamList();
    }

    @PostMapping
    public TeamDTO createTeam(@Valid @RequestBody TeamDTO team) {
        log.info("create team: {}", team);
        return service.createTeam(team);
    }
}
