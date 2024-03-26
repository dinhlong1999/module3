package com.example.demo_1109.service;

import com.example.demo_1109.model.TypeLesson;

import java.util.List;

public interface ITypeLessonService {
    int searchId(String name);
    List<TypeLesson> getAll();
}
