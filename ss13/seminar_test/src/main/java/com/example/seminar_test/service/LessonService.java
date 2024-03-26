package com.example.seminar_test.service;

import com.example.seminar_test.model.Lesson;
import com.example.seminar_test.repository.ILessonRepository;
import com.example.seminar_test.repository.LessonRepository;

import java.util.List;

public class LessonService implements  ILessonService{
    private static final ILessonRepository lessonRepository = new LessonRepository();

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.getAll();
    }

    @Override
    public void insert(Lesson lesson) {
        lessonRepository.addLesson(lesson);
    }
}
