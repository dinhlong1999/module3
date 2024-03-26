package com.example.demo_1109.service;

import com.example.demo_1109.model.Lesson;
import com.example.demo_1109.model.LessonDTO;

import java.util.List;

public interface ILessonService  {
    List<LessonDTO> getAll();
    void add(Lesson lesson);
    void delete(int id);
    void edit(int id, Lesson lesson);
    LessonDTO searchId(int id);
}
