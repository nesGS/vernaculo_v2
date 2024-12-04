package com.nesGS.vernaculo_v2.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    /* @JsonIgnore Evita que Spring serialice (convierta a JSON) esta lista (evita bucles infinitos).*/
    // se usa en conjunto con @JsonBackReference para manejar relaciones bidireccionales sin caer en bucles infinitos.
    @JsonManagedReference
    @OneToMany(mappedBy = "club")
    private List<Team> teams;

    @CreationTimestamp
    @Column(updatable = false) // Evita que este campo sea actualizado después de su creación.
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
