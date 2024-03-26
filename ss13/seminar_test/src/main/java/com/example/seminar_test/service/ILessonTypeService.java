package com.example.seminar_test.service;

import com.example.seminar_test.model.TypeLesson;

import java.util.List;

public interface ILessonTypeService {
    List<TypeLesson> getAll();
    TypeLesson findById(int id);
    TypeLesson findByName(String name);
}
