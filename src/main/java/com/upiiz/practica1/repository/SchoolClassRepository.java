package com.upiiz.practica1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.upiiz.practica1.models.SchoolClass;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolClassRepository {
    // Almacenar en un listado las clases: guardar, listar, eliminar
    // Generar de manera única el id para cada clase
    private List<SchoolClass> schoolClasses = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    // Agregamos la clase al listado y la regresamos
    // POST
    public SchoolClass save(SchoolClass schoolClass) {
        schoolClass.setId(id.incrementAndGet());
        schoolClasses.add(schoolClass);
        return schoolClass;
    }

    // GET - Todas las clases
    public List<SchoolClass> findAll() {
        return schoolClasses;
    }

    // GET - Una clase por ID
    public SchoolClass findById(Long id) {
        return schoolClasses.stream().filter(schoolClass -> schoolClass.getId().equals(id)).findFirst().orElse(null);
    }

    // DELETE - Eliminar una clase por ID
    public void delete(Long id) {
        schoolClasses.removeIf(schoolClass -> schoolClass.getId().equals(id));
    }

    // PUT - Actualizar una clase
    public SchoolClass update(SchoolClass schoolClass) {
        delete(schoolClass.getId());
        schoolClasses.add(schoolClass);
        return schoolClass;
    }
}
