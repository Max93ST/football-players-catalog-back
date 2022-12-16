package com.max.mapper;

import com.max.model.dto.PlayerDTO;
import com.max.model.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player playerDTOToPlayer(PlayerDTO playerDTO);

    PlayerDTO playerToPlayerDTO(Player player);
}
