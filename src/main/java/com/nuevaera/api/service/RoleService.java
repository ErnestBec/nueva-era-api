package com.nuevaera.api.service;

import com.nuevaera.api.dto.RoleDTO;
import com.nuevaera.api.model.Role;
import com.nuevaera.api.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(ModelMapper modelMapper, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    //save
    public RoleDTO save(RoleDTO roleDTO){
        Role role = modelMapper.map(roleDTO, Role.class);
        return modelMapper.map(roleRepository.save(role), RoleDTO.class);
    }
}
