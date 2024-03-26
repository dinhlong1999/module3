package com.example.seminar_test.service;

import com.example.seminar_test.model.TypeLesson;
import com.example.seminar_test.repository.ILessonRepository;
import com.example.seminar_test.repository.ITypeLessonRepository;
import com.example.seminar_test.repository.TypeLessonRepository;

import java.util.List;

public class TypeLessonService implements ILessonTypeService{
    private static final ITypeLessonRepository typeLessonRepository = new TypeLessonRepository();

    @Override
    public List<TypeLesson> getAll() {
        return typeLessonRepository.getAll();
    }

    @Override
    public TypeLesson findById(int id) {
        return typeLessonRepository.findById(id);
    }

    @Override
    public TypeLesson findByName(String name) {
        return typeLessonRepository.findByName(name);
    }
}
