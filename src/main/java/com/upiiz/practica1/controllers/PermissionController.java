package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.Permission;
import com.upiiz.practica1.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    // POST - Crear un nuevo permiso
    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        Permission newPermission = permissionService.save(permission);
        return ResponseEntity.ok(newPermission);
    }

    // GET - Obtener todos los permisos
    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        List<Permission> permissions = permissionService.findAll();
        return ResponseEntity.ok(permissions);
    }

    // GET - Obtener un permiso por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        Permission permission = permissionService.findById(id);
        if (permission != null) {
            return ResponseEntity.ok(permission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT - Actualizar un permiso existente
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission permission) {
        Permission existingPermission = permissionService.findById(id);
        if (existingPermission != null) {
            permission.setId(id); // Aseguramos que estamos actualizando el permiso correcto
            Permission updatedPermission = permissionService.update(permission);
            return ResponseEntity.ok(updatedPermission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar un permiso por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        Permission existingPermission = permissionService.findById(id);
        if (existingPermission != null) {
            permissionService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
