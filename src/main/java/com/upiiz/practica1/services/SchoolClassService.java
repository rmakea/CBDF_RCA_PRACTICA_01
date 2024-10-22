package com.upiiz.practica1.services;

import com.upiiz.practica1.models.SchoolClass;
import com.upiiz.practica1.repository.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    // Guardar una nueva clase
    public SchoolClass save(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    // Obtener todas las clases
    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAll();
    }

    // Obtener una clase por su ID
    public SchoolClass findById(Long id) {
        return schoolClassRepository.findById(id);
    }

    // Actualizar una clase existente
    public SchoolClass update(SchoolClass schoolClass) {
        return schoolClassRepository.update(schoolClass);
    }

    // Eliminar una clase por su ID
    public void delete(Long id) {
        schoolClassRepository.delete(id);
    }
}
