package com.nesGS.vernaculo_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String website;

    @JsonIgnore // Evita que Spring serialice (convierta a JSON) esta lista (evita bucles infinitos).
    @OneToMany(mappedBy = "club")
    private List<Team> team;

}
