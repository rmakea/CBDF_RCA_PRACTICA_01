package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.User;
import com.upiiz.practica1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school-classes/{classId}/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@PathVariable Long classId, @RequestBody User user) {
        user.setClassId(classId); // Asignar classId del path a la entidad User
        //User newUser = userService.save(user);
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsersByClassId(@PathVariable Long classId) {
        List<User> users = userService.findAllByClassId(classId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long classId, @PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null && user.getClassId().equals(classId)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long classId, @PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.findById(id);
        if (existingUser != null && existingUser.getClassId().equals(classId)) {
            user.setId(id); // Aseguramos que estamos actualizando el usuario correcto
            user.setClassId(classId); // Aseguramos que se mantenga el classId correcto
            User updatedUser = userService.update(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long classId, @PathVariable Long id) {
        User existingUser = userService.findById(id);
        if (existingUser != null && existingUser.getClassId().equals(classId)) {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
