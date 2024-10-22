package com.upiiz.practica1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.upiiz.practica1.models.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {
    private List<Role> roles = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public Role save(Role role) {
        role.setId(id.incrementAndGet());
        roles.add(role);
        return role;
    }

    public List<Role> findAll() {
        return roles;
    }

    public Role findById(Long id) {
        return roles.stream().filter(role -> role.getId().equals(id)).findFirst().orElse(null);
    }

    public void delete(Long id) {
        roles.removeIf(role -> role.getId().equals(id));
    }

    public Role update(Role role) {
        delete(role.getId());
        roles.add(role);
        return role;
    }
}
