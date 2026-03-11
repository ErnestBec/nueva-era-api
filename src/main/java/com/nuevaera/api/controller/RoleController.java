package com.nuevaera.api.controller;

import com.nuevaera.api.dto.RoleDTO;
import com.nuevaera.api.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    public final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDTO> save(@RequestBody RoleDTO roleDTO){
        System.out.println("Rol a crear: " + roleDTO.getRole() );
        return new ResponseEntity<>(roleService.save(roleDTO), HttpStatus.CREATED);
    }
}
