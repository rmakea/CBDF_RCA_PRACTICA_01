package com.upiiz.practica1.repository;

import com.upiiz.practica1.models.RoleUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class RoleUserRepository {

    private List<RoleUser> roleUsers = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    // Guardar un nuevo RoleUser
    public RoleUser save(RoleUser roleUser) {
        roleUser.setId(id.incrementAndGet());
        roleUsers.add(roleUser);
        return roleUser;
    }

    // Buscar todos los RoleUser por userId y roleId
    public List<RoleUser> findAllByUserIdAndRoleId(Long userId, Long roleId) {
        return roleUsers.stream()
                .filter(ru -> ru.getUserId().equals(userId) && ru.getRoleId().equals(roleId))
                .collect(Collectors.toList());
    }

    // Buscar un RoleUser específico por userId y roleId
    public RoleUser findByUserIdAndRoleId(Long userId, Long roleId) {
        return roleUsers.stream()
                .filter(ru -> ru.getUserId().equals(userId) && ru.getRoleId().equals(roleId))
                .findFirst()
                .orElse(null);
    }

    // Buscar un RoleUser por su ID
    public RoleUser findById(Long id) {
        return roleUsers.stream()
                .filter(roleUser -> roleUser.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Eliminar un RoleUser por su ID
    public void delete(Long id) {
        roleUsers.removeIf(roleUser -> roleUser.getId().equals(id));
    }

    // Actualizar un RoleUser
    public RoleUser update(RoleUser roleUser) {
        delete(roleUser.getId());
        roleUsers.add(roleUser);
        return roleUser;
    }
}
