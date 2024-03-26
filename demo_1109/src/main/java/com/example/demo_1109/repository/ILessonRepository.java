package com.example.demo_1109.repository;

import com.example.demo_1109.model.Lesson;
import com.example.demo_1109.model.LessonDTO;

import java.util.LinkedHashMap;
import java.util.List;

public interface ILessonRepository {
    List<LessonDTO> getAll();
    void addLesson(Lesson lesson);
    void delete(int id);
    void edit(int id, Lesson lesson);
    LessonDTO searchId(int id);
}
