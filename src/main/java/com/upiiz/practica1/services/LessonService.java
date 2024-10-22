package com.upiiz.practica1.service;

import com.upiiz.practica1.models.Lesson;
import com.upiiz.practica1.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    // Crear una nueva lección
    public Lesson createLesson(Lesson lesson, Long classId, Long teacherId) {
        return lessonRepository.save(lesson, classId, teacherId);
    }

    // Obtener todas las lecciones de una clase específica
    public List<Lesson> getLessonsByClassId(Long classId) {
        return lessonRepository.findAllByClassId(classId);
    }

    // Obtener una lección específica por su ID
    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId);
    }

    // Actualizar una lección existente
    public Lesson updateLesson(Lesson lesson, Long classId, Long teacherId) {
        return lessonRepository.update(lesson, classId, teacherId);
    }

    // Eliminar una lección
    public void deleteLesson(Long lessonId) {
        lessonRepository.delete(lessonId);
    }
}
