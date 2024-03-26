package com.example.demo_1109.repository;

import com.example.demo_1109.model.TypeLesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeLessonRepository implements ITypeLessonRepository {
    private static final String SELECT_ID = "SELECT type_lesson_id FROM type_lesson where name_type_lesson = ?;";
    private static final String SELECT_ALL = "SELECT * FROM type_lesson;";

    @Override
    public int searchId(String name) {
        int id = 0;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("type_lesson_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public List<TypeLesson> getAll() {
        List<TypeLesson> typeLessons = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
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
}