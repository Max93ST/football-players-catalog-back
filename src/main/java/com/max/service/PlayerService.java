package com.max.service;

import com.max.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO> getPlayerList();

    Long savePlayer(PlayerDTO footballPlayer);

    PlayerDTO deletePlayer(Long id);

    PlayerDTO getById(Long id);
}
