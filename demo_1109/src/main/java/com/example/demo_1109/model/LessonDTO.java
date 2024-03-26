package com.example.demo_1109.model;

public class LessonDTO {
    private int lessonId;
    private String nameLesson;
    private String typeLesson;
    private String level;
    private String link;

    public LessonDTO(int lessonId, String nameLesson, String typeLesson, String level, String link) {
        this.lessonId = lessonId;
        this.nameLesson = nameLesson;
        this.typeLesson = typeLesson;
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

    public String getTypeLesson() {
        return typeLesson;
    }

    public void setTypeLesson(String typeLesson) {
        this.typeLesson = typeLesson;
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
