package com.max.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.max.model.Country;
import com.max.model.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String firstName;
    @NotEmpty(message = "Second name should not be empty")
    @Size(min = 2, max = 255, message = "Second should be between 2 and 255 characters")
    private String secondName;
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    private TeamDTO team;
    private Country country;
    private Boolean deleted = false;
}
