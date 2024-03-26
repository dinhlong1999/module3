package com.example.seminar_test.repository;

import com.example.seminar_test.model.TypeLesson;

import java.util.List;

public interface ITypeLessonRepository {
  List<TypeLesson> getAll();
  TypeLesson findById(int id);
  TypeLesson findByName(String name);
}
