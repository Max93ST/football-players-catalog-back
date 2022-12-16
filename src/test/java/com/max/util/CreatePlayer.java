package com.max.util;

import com.max.model.Country;
import com.max.model.Gender;
import com.max.model.entity.Player;
import com.max.model.entity.Team;

import java.util.Date;

public class CreatePlayer {

    public static Player createPlayer() {
        Team team = Team.builder()
                .id(1L)
                .build();

        return Player.builder()
                .firstName("Fitbit")
                .secondName("name")
                .team(team)
                .birthday(new Date())
                .country(Country.RU)
                .gender(Gender.FEMALE)
                .deleted(false)
                .build();
    }

}
