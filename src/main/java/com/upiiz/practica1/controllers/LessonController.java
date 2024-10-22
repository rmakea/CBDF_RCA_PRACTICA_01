package com.upiiz.practica1.controllers;

import com.upiiz.practica1.models.Lesson;
import com.upiiz.practica1.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school-classes")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Crear una nueva lección para una clase y profesor específicos
    @PostMapping("/{classId}/users/{teacherId}/lessons")
    public Lesson createLesson(@PathVariable Long classId, @PathVariable Long teacherId, @RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson, classId, teacherId);
    }

    // Obtener una lección específica por su ID
    @GetMapping("/lessons/{lessonId}")
    public Lesson getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    // Actualizar una lección
    @PutMapping("/{classId}/users/{teacherId}/lessons/{lessonId}")
    public Lesson updateLesson(
            @PathVariable Long classId,
            @PathVariable Long teacherId,
            @PathVariable Long lessonId,
            @RequestBody Lesson lesson) {
        lesson.setId(lessonId);
        return lessonService.updateLesson(lesson, classId, teacherId);
    }

    // Eliminar una lección
    @DeleteMapping("/lessons/{lessonId}")
    public void deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}
