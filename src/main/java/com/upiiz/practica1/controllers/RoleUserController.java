package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.RoleUser;
import com.upiiz.practica1.services.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/{userId}/role/{roleId}/roleuser")
public class RoleUserController {

    @Autowired
    private RoleUserService roleUserService;

    // Obtener un RoleUser específico por userId y roleId
    @GetMapping
    public ResponseEntity<RoleUser> getRoleUser(@PathVariable Long userId, @PathVariable Long roleId) {
        RoleUser roleUser = roleUserService.getRoleUserByUserIdAndRoleId(userId, roleId);
        if (roleUser != null) {
            return ResponseEntity.ok(roleUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo RoleUser
    @PostMapping
    public ResponseEntity<RoleUser> createRoleUser(@PathVariable Long userId, @PathVariable Long roleId) {
        RoleUser newRoleUser = roleUserService.createRoleUser(userId, roleId);
        return ResponseEntity.ok(newRoleUser);
    }

    // Actualizar un RoleUser existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<RoleUser> updateRoleUserById(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long id) {
        RoleUser updatedRoleUser = roleUserService.updateRoleUserById(userId, roleId, id);
        if (updatedRoleUser != null) {
            return ResponseEntity.ok(updatedRoleUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un RoleUser por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleUserById(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long id) {
        boolean deleted = roleUserService.deleteRoleUserById(userId, roleId, id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
