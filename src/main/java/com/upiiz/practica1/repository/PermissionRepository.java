package com.upiiz.practica1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.upiiz.practica1.models.Permission;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionRepository {
    // Almacenar en un listado los permisos: guardar, listar, eliminar
    // Generar de manera única el id para cada permiso
    private List<Permission> permissions = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    // Agregamos el permiso al listado y lo regresamos
    // POST
    public Permission save(Permission permission) {
        permission.setId(id.incrementAndGet());
        permissions.add(permission);
        return permission;
    }

    // GET - Todos los permisos
    public List<Permission> findAll() {
        return permissions;
    }

    // GET - Un permiso por ID
    public Permission findById(Long id) {
        return permissions.stream().filter(permission -> permission.getId().equals(id)).findFirst().orElse(null);
    }

    // DELETE - Eliminar un permiso por ID
    public void delete(Long id) {
        permissions.removeIf(permission -> permission.getId().equals(id));
    }

    // PUT - Actualizar un permiso
    public Permission update(Permission permission) {
        delete(permission.getId());
        permissions.add(permission);
        return permission;
    }
}
