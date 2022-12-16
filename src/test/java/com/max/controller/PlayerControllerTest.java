package com.max.controller;

import com.max.model.dto.PlayerDTO;
import com.max.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {
    private final static long ID = 1L;

    @Mock
    private SimpMessagingTemplate template;

    @Mock
    private PlayerService service;

    @InjectMocks
    private PlayerController controller;

    @Test
    void createPlayer() {
        final PlayerDTO playerDTO = mock(PlayerDTO.class);

        controller.createPlayer(playerDTO);

        verify(service).savePlayer(playerDTO);
        verify(template).convertAndSend("/topic/player", service.getById(ID));
    }

}
