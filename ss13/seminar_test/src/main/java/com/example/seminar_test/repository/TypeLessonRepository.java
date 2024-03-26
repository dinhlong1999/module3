package com.example.seminar_test.repository;

import com.example.seminar_test.model.TypeLesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeLessonRepository implements  ITypeLessonRepository{
    private static final String SEARCH_TYPE = "select * from type_lesson where type_lesson_id = ?;";
    private static final String INSERT = "insert into type_lesson(name_type_lesson) values(?);";
    private static final String SHOW_ALL = "SELECT * FROM type_lesson;";
    private static final String SEARCH_BY_NAME = "select * from type_lesson where name_type_lesson = ?;";



    @Override
    public List<TypeLesson> getAll() {
        List<TypeLesson> typeLessons = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement   preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("type_lesson_id");
                String name = resultSet.getString("name_type_lesson");
                typeLessons.add(new TypeLesson(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return typeLessons;
    }

    @Override
    public TypeLesson findById(int id) {
        TypeLesson typeLesson = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TYPE);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name_type_lesson");
                typeLesson = new TypeLesson(id,name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeLesson;
    }

    @Override
    public TypeLesson findByName(String name) {
        TypeLesson typeLesson = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("type_lesson_id");
                typeLesson = new TypeLesson(id,name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeLesson;
    }
}
