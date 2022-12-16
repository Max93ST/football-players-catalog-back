package com.max.repository;

import com.max.IntegrationTestBase;
import com.max.model.entity.Player;
import com.max.util.CreatePlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerRepositoryTest extends IntegrationTestBase {

    private static final Long PLAYER_ID = 1L;

    @Autowired
    private PlayerRepository repository;

    @Test
    void testFindById() {
        Optional<Player> player = repository.findById(PLAYER_ID);
        assertTrue(player.isPresent());
        player.ifPresent(entity -> {
            assertEquals("Max", entity.getFirstName());
        });
    }

    @Test
    void testSave() {
        Player player = CreatePlayer.createPlayer();
        repository.save(player);
        assertNotNull(player.getId());
    }

    @Test
    void testDelete() {
        Player playerExample = CreatePlayer.createPlayer();
        Long id = repository.save(playerExample).getId();

        repository.deleteById(id);

        Optional<Player> player = repository.findById(id);

        player.ifPresent(entity -> {
            assertEquals(true, entity.getDeleted());
        });
    }
}
