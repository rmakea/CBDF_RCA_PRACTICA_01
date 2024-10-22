package com.upiiz.practica1.services;

import com.upiiz.practica1.models.PermissionRole;
import com.upiiz.practica1.repository.PermissionRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionRoleService {

    @Autowired
    private PermissionRoleRepository permissionRoleRepository;

    // Buscar PermissionRole por roleId y permissionId
    public PermissionRole getPermissionRoleByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        return permissionRoleRepository.findByRoleIdAndPermissionId(roleId, permissionId);
    }

    // Crear un nuevo PermissionRole
    public PermissionRole createPermissionRole(Long permissionId, Long roleId) {
        PermissionRole permissionRole = new PermissionRole();
        permissionRole.setPermissionId(permissionId);
        permissionRole.setRoleId(roleId);
        return permissionRoleRepository.save(permissionRole);
    }

    // Actualizar un PermissionRole existente por ID, roleId y permissionId
    public PermissionRole updatePermissionRoleById(Long roleId, Long permissionId, Long id) {
        PermissionRole existingPermissionRole = permissionRoleRepository.findById(id);
        if (existingPermissionRole != null && existingPermissionRole.getRoleId().equals(roleId) && existingPermissionRole.getPermissionId().equals(permissionId)) {
            return permissionRoleRepository.update(existingPermissionRole);
        }
        return null; // Si no se encuentra el PermissionRole, retorna null
    }

    // Eliminar PermissionRole por ID, roleId y permissionId
    public boolean deletePermissionRoleById(Long roleId, Long permissionId, Long id) {
        PermissionRole existingPermissionRole = permissionRoleRepository.findById(id);
        if (existingPermissionRole != null && existingPermissionRole.getRoleId().equals(roleId) && existingPermissionRole.getPermissionId().equals(permissionId)) {
            permissionRoleRepository.delete(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró el PermissionRole
    }
}
