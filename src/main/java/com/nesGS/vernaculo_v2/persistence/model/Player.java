package com.nesGS.vernaculo_v2.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "ranking", nullable = false, length = 100)
    private String range;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @ManyToOne
    @JoinColumn(name = "team_id")     // Foreign key que hace referencia al campo id en la tabla equipo
    private Team team;

    @JsonIgnore // Evita que Spring serialice (convierta a JSON) esta lista (evita bucles infinitos).
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<PlayerStats> playerStats;



}
