package com.nuevaera.api.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Integer user_id;
    private  Integer person_id;
    private String email;
    private String password;
    private Set<Integer> roles;
    private boolean is_active;
}
