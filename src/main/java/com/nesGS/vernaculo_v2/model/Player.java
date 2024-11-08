package com.nesGS.vernaculo_v2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "luchador")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String name;

    @Column(name = "jerarquía", nullable = false, length = 100)
    private String range;

    @Column(name = "edad", nullable = false)
    private Date birth;

    @ManyToOne
    @JoinColumn(name = "equipo_id")     // Foreign key que hace referencia al campo id en la tabla equipo
    private Team team;


}
