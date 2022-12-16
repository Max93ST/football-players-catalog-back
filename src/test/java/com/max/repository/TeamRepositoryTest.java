package com.max.repository;

import com.max.IntegrationTestBase;
import com.max.model.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamRepositoryTest extends IntegrationTestBase {

    @Autowired
    TeamRepository repository;

    @Autowired
    EntityManager manager;

    @Test()
    void notUniqueNameTest() {
        Team team = new Team();
        team.setName("Perm");

        repository.save(team);

        assertThrows(PersistenceException.class, () -> manager.flush());
    }
}
