package com.example.seminar_test.model;

public class TypeLesson {
    private int typeLessonID;
    private String nameType;

    public TypeLesson(int typeLessonID, String nameType) {
        this.typeLessonID = typeLessonID;
        this.nameType = nameType;
    }

    public TypeLesson(String nameType) {
        this.nameType = nameType;
    }

    public int getTypeLessonID() {
        return typeLessonID;
    }

    public void setTypeLessonID(int typeLessonID) {
        this.typeLessonID = typeLessonID;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
