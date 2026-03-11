package com.nuevaera.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    //Relacion Uno a Uno con Person, se hara una relacion en cascada
    @OneToOne(cascade = CascadeType.ALL)
    //Se forma la relacion mediante el campo person_id a la tabla de person con person_id
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    private String email;
    private String password_hash;
    private boolean is_active;

    //Relación muchos a muchos con roles
    @ManyToMany
    @JoinTable(
            name = "user_role", //Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "user_id"), //FK hacia usuario
            inverseJoinColumns = @JoinColumn(name = "role_id") //FK hacia role
    )
    private Set<Role> roles = new HashSet<>();

    @Column(updatable = false)
    @CreationTimestamp
    private Date created_at;
    @UpdateTimestamp
    private Date updated_at;

}
