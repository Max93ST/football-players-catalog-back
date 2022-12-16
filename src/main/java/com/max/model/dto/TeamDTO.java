package com.max.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    private Long id;
    @NotEmpty(message = "Team name should not be empty")
    @Size(min = 2, max = 255, message = "Team name be between 2 and 255 characters")
    private String name;
}
