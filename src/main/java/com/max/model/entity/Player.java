package com.max.model.entity;

import com.max.model.Country;
import com.max.model.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update player set deleted=true where id=?")
@Where(clause = "deleted = false")
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String secondName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date birthday;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
}
