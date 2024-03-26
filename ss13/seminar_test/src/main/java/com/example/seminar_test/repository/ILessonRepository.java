package com.example.seminar_test.repository;

import com.example.seminar_test.model.Lesson;

import java.util.List;

public interface ILessonRepository {
    void addLesson(Lesson lesson);
    List<Lesson> getAll();
    void editLesson(int id, Lesson lesson);
    void deleteLesson(int id);
    Lesson searchLesson(String name);
    void sortLesson(List<Lesson> lessonList);
}
