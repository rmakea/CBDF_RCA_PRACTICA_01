package com.upiiz.practica1.repository;

import com.upiiz.practica1.models.Lesson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class LessonRepository {
    private List<Lesson> lessons = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    // Guardar nueva lección
    public Lesson save(Lesson lesson, Long classId, Long teacherId) {
        lesson.setId(id.incrementAndGet());
        lesson.setClassId(classId);
        lesson.setTeacherId(teacherId);
        lessons.add(lesson);
        return lesson;
    }

    // Obtener todas las lecciones de una clase específica
    public List<Lesson> findAllByClassId(Long classId) {
        return lessons.stream().filter(lesson -> lesson.getClassId().equals(classId)).collect(Collectors.toList());
    }

    // Obtener una lección por su ID
    public Lesson findById(Long id) {
        return lessons.stream().filter(lesson -> lesson.getId().equals(id)).findFirst().orElse(null);
    }

    // Eliminar una lección por su ID
    public void delete(Long id) {
        lessons.removeIf(lesson -> lesson.getId().equals(id));
    }

    // Actualizar lección existente
    public Lesson update(Lesson lesson, Long classId, Long teacherId) {
        delete(lesson.getId());
        lesson.setClassId(classId);
        lesson.setTeacherId(teacherId);
        lessons.add(lesson);
        return lesson;
    }
}
