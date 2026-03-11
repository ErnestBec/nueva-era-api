package com.nuevaera.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "person")
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;
    private String name;
    private String app;
    private String apm;
    //fecha de cumpleaños pendiente de definir tipo
    //private Date birthday_date;
    private String rfc;
    @OneToOne(mappedBy = "person")
    private User user;

    @Column(updatable = false)
    @CreationTimestamp
    private Date created_at;
    @UpdateTimestamp
    private Date update_at;

}
