package com.example.demo_1109.repository;

import com.example.demo_1109.model.Lesson;
import com.example.demo_1109.model.LessonDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonRepository  implements  ILessonRepository{
    private static final String SELECT_ALL = "select lesson.lesson_id, lesson.name_lesson, type_lesson.name_type_lesson, lesson.`level`, lesson.link_lesson from lesson " +
            "join type_lesson  on type_lesson.type_lesson_id = lesson.type_lesson_id where is_deleted = 0;;";
    private static final String INSERT = "insert into `lesson`(name_lesson, type_lesson_id, `level`,`link_lesson`)" +
            "values(?,?,?,?);";
    private static final String DELETE = "UPDATE lesson set is_deleted = 1 where lesson_id =?;";
    private static final ITypeLessonRepository typeLessonRepository = new TypeLessonRepository();
    private static final String FIND_BY_ID = "select lesson.lesson_id, lesson.name_lesson, type_lesson.name_type_lesson, lesson.`level`, lesson.link_lesson from lesson \n" +
            "join type_lesson  on type_lesson.type_lesson_id = lesson.type_lesson_id where is_deleted = 0 AND lesson.lesson_id =?;";
    private static final String UPDATE ="UPDATE lesson set name_lesson = ?, type_lesson_id = ?, level= ?, link_lesson = ? WHERE lesson_id = ?;";
    @Override
    public List<LessonDTO> getAll() {
        List<LessonDTO> lessonDTOList = new ArrayList<>();

        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("lesson_id");
                String nameLesson = resultSet.getString("name_lesson");
                String nameType = resultSet.getString("name_type_lesson");
                String level = resultSet.getString("level");
                String link = resultSet.getString("link_lesson");
                lessonDTOList.add(new LessonDTO(id,nameLesson,nameType,level,link));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessonDTOList;
    }

    @Override
    public void addLesson(Lesson lesson) {
        Connection connection =BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,lesson.getNameLesson());
            preparedStatement.setInt(2,lesson.getTypeId());
            preparedStatement.setString(3,lesson.getLevel());
            preparedStatement.setString(4,lesson.getLink());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Lesson lesson) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, lesson.getNameLesson());
            preparedStatement.setInt(2, lesson.getTypeId());
            preparedStatement.setString(3, lesson.getLevel());
            preparedStatement.setString(4, lesson.getLink());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public LessonDTO searchId(int id) {
        LessonDTO lessonDTO = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int lessonId =resultSet.getInt("lesson_id");
                String lessonName = resultSet.getString("name_lesson");
                String typeLesson = resultSet.getString("name_type_lesson");
                String level = resultSet.getString("level");
                String link = resultSet.getString("link_lesson");
                lessonDTO = new LessonDTO(lessonId,lessonName,typeLesson,level,link);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lessonDTO;
    }
}
