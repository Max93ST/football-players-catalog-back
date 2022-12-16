package com.max.controller;

import com.max.model.dto.PlayerDTO;
import com.max.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService service;
    private final SimpMessagingTemplate template;

    @PostMapping(value = "/players")
    public void createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        log.info("create player: {}", playerDTO);
        Long id = service.savePlayer(playerDTO);
        template.convertAndSend("/topic/player", service.getById(id));
    }

    @GetMapping(value = "/players")
    public List<PlayerDTO> getList() {
        log.info("get player list");
        return service.getPlayerList();
    }

    @MessageMapping("/delete")
    @SendTo("/topic/player")
    public PlayerDTO delete(Long id) {
        log.info("delete player with id: {}", id);
        return service.deletePlayer(id);
    }

    @MessageMapping("/update")
    @SendTo("/topic/player")
    public PlayerDTO change(PlayerDTO playerDTO) {
        log.info("update player: {}", playerDTO);
        Long id = service.savePlayer(playerDTO);
        return service.getById(id);
    }
}
