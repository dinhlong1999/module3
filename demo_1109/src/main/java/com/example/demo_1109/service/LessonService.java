package com.example.demo_1109.service;

import com.example.demo_1109.model.Lesson;
import com.example.demo_1109.model.LessonDTO;
import com.example.demo_1109.repository.ILessonRepository;
import com.example.demo_1109.repository.LessonRepository;

import java.util.List;

public class LessonService implements ILessonService {
    private static final ILessonRepository lessonRepository = new LessonRepository();
    @Override
    public List<LessonDTO> getAll() {
        return lessonRepository.getAll();
    }

    @Override
    public void add(Lesson lesson) {
        lessonRepository.addLesson(lesson);
    }

    @Override
    public void delete(int id) {
        lessonRepository.delete(id);
    }

    @Override
    public void edit(int id, Lesson lesson) {
        lessonRepository.edit(id,lesson);
    }

    @Override
    public LessonDTO searchId(int id) {
        return lessonRepository.searchId(id);
    }
}
