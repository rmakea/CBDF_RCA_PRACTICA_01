package com.upiiz.practica1.service;

import com.upiiz.practica1.models.Role;
import com.upiiz.practica1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id);
    }

    public Role update(Role role) {
        return roleRepository.update(role);
    }

    public void delete(Long id) {
        roleRepository.delete(id);
    }
}
