package com.upiiz.practica1.services;

import com.upiiz.practica1.models.Permission;
import com.upiiz.practica1.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    // Guardar un nuevo permiso
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    // Obtener todos los permisos
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    // Obtener un permiso por su ID
    public Permission findById(Long id) {
        return permissionRepository.findById(id);
    }

    // Actualizar un permiso existente
    public Permission update(Permission permission) {
        return permissionRepository.update(permission);
    }

    // Eliminar un permiso por su ID
    public void delete(Long id) {
        permissionRepository.delete(id);
    }
}
