package com.nuevaera.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {
    private Integer person_id;
    private String name;
    private String app;
    private String apm;
    //Pendiente de declarar
    //private Date brithday_date;
    private String rfc;
}
