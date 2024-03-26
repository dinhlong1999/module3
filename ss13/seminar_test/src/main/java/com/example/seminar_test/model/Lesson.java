package com.example.seminar_test.model;

public class Lesson {
    private int lessonId;
    private String nameLesson;
    private TypeLesson typeLesson;
    private String level;
    private int module;
    private String linkLesson;

    public Lesson(int lessonId, String nameLesson, TypeLesson typeLesson, String level, int module, String linkLesson) {
        this.lessonId = lessonId;
        this.nameLesson = nameLesson;
        this.typeLesson = typeLesson;
        this.level = level;
        this.module = module;
        this.linkLesson = linkLesson;
    }

    public Lesson(String nameLesson, TypeLesson typeLesson, String level, int module, String linkLesson) {
        this.nameLesson = nameLesson;
        this.typeLesson = typeLesson;
        this.level = level;
        this.module = module;
        this.linkLesson = linkLesson;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public TypeLesson getTypeLesson() {
        return typeLesson;
    }

    public void setTypeLesson(TypeLesson typeLesson) {
        this.typeLesson = typeLesson;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getLinkLesson() {
        return linkLesson;
    }

    public void setLinkLesson(String linkLesson) {
        this.linkLesson = linkLesson;
    }
}
