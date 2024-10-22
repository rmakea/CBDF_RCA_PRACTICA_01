package com.upiiz.practica1.services;

import com.upiiz.practica1.models.RoleUser;
import com.upiiz.practica1.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUserService {

    @Autowired
    private RoleUserRepository roleUserRepository;

    // Buscar RoleUser por userId y roleId
    public RoleUser getRoleUserByUserIdAndRoleId(Long userId, Long roleId) {
        return roleUserRepository.findByUserIdAndRoleId(userId, roleId);
    }

    // Crear un nuevo RoleUser
    public RoleUser createRoleUser(Long userId, Long roleId) {
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(userId);
        roleUser.setRoleId(roleId);
        return roleUserRepository.save(roleUser);
    }

    // Actualizar un RoleUser existente por ID, userId y roleId
    public RoleUser updateRoleUserById(Long userId, Long roleId, Long id) {
        RoleUser existingRoleUser = roleUserRepository.findById(id);
        if (existingRoleUser != null && existingRoleUser.getUserId().equals(userId) && existingRoleUser.getRoleId().equals(roleId)) {
            // Actualiza las propiedades necesarias del RoleUser
            // existingRoleUser.setSomeField(newValue);
            return roleUserRepository.update(existingRoleUser);
        }
        return null; // Si no se encuentra el RoleUser, retorna null
    }

    // Eliminar RoleUser por ID, userId y roleId
    public boolean deleteRoleUserById(Long userId, Long roleId, Long id) {
        RoleUser existingRoleUser = roleUserRepository.findById(id);
        if (existingRoleUser != null && existingRoleUser.getUserId().equals(userId) && existingRoleUser.getRoleId().equals(roleId)) {
            roleUserRepository.delete(id);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró el RoleUser
    }
}
