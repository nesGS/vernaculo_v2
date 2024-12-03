package com.nesGS.vernaculo_v2.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int scoreHome;
    private int scoreAway;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeamId;

    @JsonIgnore
    @JoinColumn(name = "away_team_id")
    @ManyToOne
    private Team awayTeamId;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
}
