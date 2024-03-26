package com.example.seminar_test.service;

import com.example.seminar_test.model.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> getAll();
    void insert(Lesson lesson);
}
