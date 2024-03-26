package com.example.demo_1109.repository;

import com.example.demo_1109.model.TypeLesson;

import java.util.List;

public interface ITypeLessonRepository {
    int searchId(String name);
    List<TypeLesson> getAll();
}
