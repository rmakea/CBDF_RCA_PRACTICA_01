package com.upiiz.practica1.repository;

import com.upiiz.practica1.models.PermissionRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PermissionRoleRepository {

    private List<PermissionRole> permissionRoles = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    // Guardar un nuevo PermissionRole
    public PermissionRole save(PermissionRole permissionRole) {
        permissionRole.setId(id.incrementAndGet());
        permissionRoles.add(permissionRole);
        return permissionRole;
    }

    // Buscar todos los PermissionRole por roleId
    public List<PermissionRole> findAllByRoleId(Long roleId) {
        return permissionRoles.stream()
                .filter(pr -> pr.getRoleId().equals(roleId))
                .collect(Collectors.toList());
    }

    // Buscar un PermissionRole específico por roleId y permissionId
    public PermissionRole findByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        return permissionRoles.stream()
                .filter(pr -> pr.getRoleId().equals(roleId) && pr.getPermissionId().equals(permissionId))
                .findFirst()
                .orElse(null);
    }

    // Buscar un PermissionRole por su ID
    public PermissionRole findById(Long id) {
        return permissionRoles.stream()
                .filter(permissionRole -> permissionRole.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Eliminar un PermissionRole por su ID
    public void delete(Long id) {
        permissionRoles.removeIf(permissionRole -> permissionRole.getId().equals(id));
    }

    // Actualizar un PermissionRole
    public PermissionRole update(PermissionRole permissionRole) {
        delete(permissionRole.getId());
        permissionRoles.add(permissionRole);
        return permissionRole;
    }
}
