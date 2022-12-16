package com.max.service;

import com.max.mapper.PlayerMapper;
import com.max.model.dto.PlayerDTO;
import com.max.model.entity.Player;
import com.max.repository.PlayerRepository;
import com.max.service.implementation.PlayerServiceImpl;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    private final static long ID = 1L;
    @Mock
    PlayerRepository repository;

    @Mock
    PlayerMapper mapper;

    @Mock
    EntityManager manager;

    @InjectMocks
    PlayerServiceImpl service;

    @Test
    void getByIdTest() {
        final Player player = mock(Player.class);
        final PlayerDTO playerDTO = mock(PlayerDTO.class);

        when(repository.findById(ID)).thenReturn(Optional.of(player));
        when(mapper.playerToPlayerDTO(player)).thenReturn(playerDTO);

        service.getById(ID);

        verify(repository).findById(ID);
        verify(manager).refresh(player);
        verify(mapper).playerToPlayerDTO(player);

    }

    @Test
    void savePlayerTest() {
        final Player player = mock(Player.class);
        final PlayerDTO playerDTO = mock(PlayerDTO.class);

        when(repository.save(player)).thenReturn(player);
        when(player.getId()).thenReturn(ID);
        when(mapper.playerDTOToPlayer(playerDTO)).thenReturn(player);

        service.savePlayer(playerDTO);

        verify(mapper).playerDTOToPlayer(playerDTO);
        verify(repository).save(player);
        verify(player).getId();
    }

    @Test
    void deletePlayer() {
        final Player player = mock(Player.class);
        final PlayerDTO playerDTO = mock(PlayerDTO.class);

        when(repository.findById(ID)).thenReturn(Optional.of(player));
        when(mapper.playerToPlayerDTO(player)).thenReturn(playerDTO);

        service.deletePlayer(ID);

        verify(repository).findById(ID);
        verify(player).setDeleted(true);
        verify(repository).save(player);
        verify(mapper).playerToPlayerDTO(player);

    }
}
