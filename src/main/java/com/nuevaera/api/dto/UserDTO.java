package com.nuevaera.api.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer user_id;
    private String email;
    private String password;
    private boolean is_active;
}
