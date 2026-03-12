package com.nuevaera.api.service;

import com.nuevaera.api.dto.RoleDTO;
import com.nuevaera.api.model.Role;
import com.nuevaera.api.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleService(ModelMapper modelMapper, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    //save
    public RoleDTO save(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        return modelMapper.map(roleRepository.save(role), RoleDTO.class);
    }

    //findAll
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(
                role -> {
                    return modelMapper.map(role, RoleDTO.class);
                }
        ).collect(Collectors.toList());
    }

    //findById
    public Optional<RoleDTO> findById(Integer id) {
        return roleRepository.findById(id).map(
                role -> {
                    return modelMapper.map(role, RoleDTO.class);
                }
        );
    }

    //delete
    public Boolean deleteById(Integer id) {
        return roleRepository.findById(id).map(
                role -> {
                    roleRepository.delete(role);
                    return true;
                }
        ).orElse(false);
    }

    //update
    public Optional<RoleDTO> update(@RequestBody RoleDTO roleDTO) {

        Role role = modelMapper.map(roleDTO, Role.class);

        return roleRepository.findById(role.getRole_id()).map(
                roleDB -> {
                    return modelMapper.map(roleRepository.save(role), RoleDTO.class);
                }
        );

    }

}
