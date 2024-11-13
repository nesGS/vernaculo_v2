package com.nesGS.vernaculo_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String season;

    private boolean currentYear;

    @JsonIgnore
    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Match> competitions;

}
