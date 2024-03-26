package com.example.demo_1109.model;

public class Lesson {
    private int lessonId;
    private String nameLesson;
    private int typeId;
    private String level;
    private String link;

    public Lesson(int lessonId, String nameLesson, int typeId, String level, String link) {
        this.lessonId = lessonId;
        this.nameLesson = nameLesson;
        this.typeId = typeId;
        this.level = level;
        this.link = link;
    }

    public Lesson(String nameLesson, int typeId, String level, String link) {
        this.nameLesson = nameLesson;
        this.typeId = typeId;
        this.level = level;
        this.link = link;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
