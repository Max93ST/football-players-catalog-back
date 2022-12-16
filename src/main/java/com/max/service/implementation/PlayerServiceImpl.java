package com.max.service.implementation;

import com.max.mapper.PlayerMapper;
import com.max.model.dto.PlayerDTO;
import com.max.model.entity.Player;
import com.max.repository.PlayerRepository;
import com.max.service.PlayerService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;
    private final EntityManager entityManager;
    private final PlayerMapper mapper;

    @Override
    public List<PlayerDTO> getPlayerList() {
        return repository.findAll().stream().map(mapper::playerToPlayerDTO).toList();
    }

    @Override
    @Transactional
    public Long savePlayer(PlayerDTO player) {
        return repository.save(mapper.playerDTOToPlayer(player)).getId();
    }

    @Override
    @Transactional
    public PlayerDTO getById(Long id) {
        Player player = repository.findById(id).orElseThrow();
        entityManager.refresh(player);
        return mapper.playerToPlayerDTO(player);
    }


    @Override
    @Transactional
    public PlayerDTO deletePlayer(Long id) {
        Player player = repository.findById(id).orElseThrow();
        player.setDeleted(true);
        repository.save(player);
        return mapper.playerToPlayerDTO(player);
    }
}
