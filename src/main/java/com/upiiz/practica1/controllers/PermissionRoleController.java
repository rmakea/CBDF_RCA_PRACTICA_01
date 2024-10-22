package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.PermissionRole;
import com.upiiz.practica1.services.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role/{roleId}/permission/{permissionId}/permissionrole")
public class PermissionRoleController {

    @Autowired
    private PermissionRoleService permissionRoleService;

    // Obtener un PermissionRole específico por roleId y permissionId
    @GetMapping
    public ResponseEntity<PermissionRole> getPermissionRole(@PathVariable Long roleId, @PathVariable Long permissionId) {
        PermissionRole permissionRole = permissionRoleService.getPermissionRoleByRoleIdAndPermissionId(roleId, permissionId);
        if (permissionRole != null) {
            return ResponseEntity.ok(permissionRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo PermissionRole
    @PostMapping
    public ResponseEntity<PermissionRole> createPermissionRole(@PathVariable Long roleId, @PathVariable Long permissionId) {
        PermissionRole newPermissionRole = permissionRoleService.createPermissionRole(permissionId, roleId);
        return ResponseEntity.ok(newPermissionRole);
    }

    // Actualizar un PermissionRole existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<PermissionRole> updatePermissionRoleById(@PathVariable Long roleId, @PathVariable Long permissionId, @PathVariable Long id) {
        PermissionRole updatedPermissionRole = permissionRoleService.updatePermissionRoleById(roleId, permissionId, id);
        if (updatedPermissionRole != null) {
            return ResponseEntity.ok(updatedPermissionRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un PermissionRole por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissionRoleById(@PathVariable Long roleId, @PathVariable Long permissionId, @PathVariable Long id) {
        boolean deleted = permissionRoleService.deletePermissionRoleById(roleId, permissionId, id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
