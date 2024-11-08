package com.nesGS.vernaculo_v2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "equipo")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String name;

    private String category;
    private String coach;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;


    // mappedBy = "teams" indica que la relación es bidireccional y está mapeada por el campo team en la clase Player

    // El cascade = CascadeType.ALL hace que cualquier operación en Team (guardar, eliminar, actualizar) se aplique
    // en cascada a los jugadores asociados.

}
