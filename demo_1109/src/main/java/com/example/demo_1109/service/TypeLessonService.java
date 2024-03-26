package com.example.demo_1109.service;

import com.example.demo_1109.model.TypeLesson;
import com.example.demo_1109.repository.ILessonRepository;
import com.example.demo_1109.repository.ITypeLessonRepository;
import com.example.demo_1109.repository.TypeLessonRepository;

import java.util.List;

public class TypeLessonService implements  ITypeLessonService{
    private static final ITypeLessonRepository typeLessonRepository = new TypeLessonRepository();
    @Override
    public int searchId(String name) {
        return typeLessonRepository.searchId(name);
    }

    @Override
    public List<TypeLesson> getAll() {
        return typeLessonRepository.getAll();
    }
}
