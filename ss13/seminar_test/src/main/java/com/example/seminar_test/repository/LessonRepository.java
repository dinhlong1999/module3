package com.example.seminar_test.repository;

import com.example.seminar_test.model.Lesson;
import com.example.seminar_test.model.TypeLesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonRepository implements ILessonRepository {
    private static final String SELECT_ALL = "SELECT * FROM lesson;";
    private static final String INSERT = "INSERT INTO `lesson`(name_lesson,type_lesson_id,`level`,`module`,link_lesson)" +
            "values(?,?,?,?,?);";
    private static final String DELETE = "DELETE FROM `lesson` WHERE lesson_id = ?;";
    private static final ITypeLessonRepository typeLessonRepository = new TypeLessonRepository();


    @Override
    public void addLesson(Lesson lesson) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,lesson.getNameLesson());
            preparedStatement.setInt(2,lesson.getTypeLesson().getTypeLessonID());
            preparedStatement.setString(3,lesson.getLevel());
            preparedStatement.setInt(4,lesson.getModule());
            preparedStatement.setString(5,lesson.getLinkLesson());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lesson> getAll() {
        List<Lesson> lessonList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("lesson_id");
                String name = resultSet.getString("name_lesson");
                int typeLessonId = resultSet.getInt("type_lesson_id");
                TypeLesson typeLesson = typeLessonRepository.findById(typeLessonId);
                String level = resultSet.getString("level");
                int module = resultSet.getInt("module");
                String link = resultSet.getString("link_lesson");
                lessonList.add(new Lesson(id,name,typeLesson,level,module,link));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessonList;
    }

    @Override
    public void editLesson(int id, Lesson lesson) {

    }

    @Override
    public void deleteLesson(int id) {

    }

    @Override
    public Lesson searchLesson(String name) {
        return null;
    }

    @Override
    public void sortLesson(List<Lesson> lessonList) {

    }
}
