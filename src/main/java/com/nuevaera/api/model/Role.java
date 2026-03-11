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
@Table(name = "role")
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;
    private String description;
    private String role;

    // Relation many to many to tbale user
    @ManyToMany(mappedBy = "roles")
    private Set<User> users= new HashSet<>();

    //Indica que no se actualizara cuando se actualice algun campo
    @Column(updatable = false)
    //Solo se inserta la fecha cuando se crea el registro
    @CreationTimestamp
    private Date created_at;
    //Se actualiza cada que reciba una alcualizacion cualquier campo
    @UpdateTimestamp
    private Date updated_at;

}
