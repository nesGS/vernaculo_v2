package com.nesGS.vernaculo_v2.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @JsonIgnore // Evita que las peticiones GET den más info que las propias estadíasticas.
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
