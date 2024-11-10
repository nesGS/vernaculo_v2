package com.nesGS.vernaculo_v2.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int winRounds;
    private int loseRounds;
    private int advices;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
