package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.SchoolClass;
import com.upiiz.practica1.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school-classes")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    // POST - Crear una nueva clase
    @PostMapping
    public ResponseEntity<SchoolClass> createSchoolClass(@RequestBody SchoolClass schoolClass) {
        SchoolClass newClass = schoolClassService.save(schoolClass);
        return ResponseEntity.ok(newClass);
    }

    // GET - Obtener todas las clases
    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAllSchoolClasses() {
        List<SchoolClass> classes = schoolClassService.findAll();
        return ResponseEntity.ok(classes);
    }

    // GET - Obtener una clase por su ID
    @GetMapping("/{id}")
    public ResponseEntity<SchoolClass> getSchoolClassById(@PathVariable Long id) {
        SchoolClass schoolClass = schoolClassService.findById(id);
        if (schoolClass != null) {
            return ResponseEntity.ok(schoolClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT - Actualizar una clase existente
    @PutMapping("/{id}")
    public ResponseEntity<SchoolClass> updateSchoolClass(@PathVariable Long id, @RequestBody SchoolClass schoolClass) {
        SchoolClass existingClass = schoolClassService.findById(id);
        if (existingClass != null) {
            schoolClass.setId(id); // Aseguramos que estamos actualizando la clase correcta
            SchoolClass updatedClass = schoolClassService.update(schoolClass);
            return ResponseEntity.ok(updatedClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar una clase por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchoolClass(@PathVariable Long id) {
        SchoolClass existingClass = schoolClassService.findById(id);
        if (existingClass != null) {
            schoolClassService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
