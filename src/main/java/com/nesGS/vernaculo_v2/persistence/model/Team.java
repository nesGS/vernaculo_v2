package com.nesGS.vernaculo_v2.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    private String category;
    private String coach;

    @JsonIgnore // Evita que Spring serialice (convierta a JSON) esta lista (evita bucles infinitos).
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @ManyToOne
    @JoinColumn (name = "club_id")     // Foreign key que hace referencia al campo id en la tabla club
    private Club club;


    // mappedBy = "teams" indica que la relación es bidireccional y está mapeada por el campo team en la clase Player

    // El cascade = CascadeType.ALL hace que cualquier operación en Team (guardar, eliminar, actualizar) se aplique
    // en cascada a los jugadores asociados.


    /*
    * ANOTACIONES DE JACKSON PARA CONTROLAR CÓMO SE SERIALIZAN Y DESERIALIZAN LAS PROPIEDADES DE LA CLASE:
    *
    * -@JsonIgnore: Evita que Spring serialice (convierta a JSON) esta lista (evita bucles infinitos).
    *
    * -@JsonManageReference: indica que esta es la “dirección principal” de la relación. Esto le dice a Jackson que
    *   serialice el campo players (para incluir la lista de jugadores de un equipo) cuando esté en un Team, pero no
    *   siga serializando hacia atrás a los Player una y otra vez.
    *
    * -@JsonBackReference: Dice a Jackson (la biblioteca de serialización JSON de Spring Boot) que no serialice este
    *   campo cuando está dentro de un bucle.
     * */

}
