package com.example.usermanager.repository;

import com.example.usermanager.model.User;
import sun.dc.pr.PRError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users(`name`,email,country) VALUES(?,?,?);";
    private static final String SELECT_USERS_SQL = "SELECT id,name,email,country from users WHERE id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users order by name";
    private static final String DELETE_USERS_SQL = "DELETE FORM users where id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users set name =?, email=?, country=? where id=?;";
    private static final String DELETE_USERS = "UPDATE `users` SET `is_delete` = b'1' WHERE (`id` = ?);";
    private static final String SELECT_USERS_ADDRESS = "SELECT id,`name`,email,country FROM users;";

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.executeUpdate();

    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()) {
                if (!resultSet.getBoolean("is_delete")) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    userList.add(new User(id, name, email, country));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;

    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();


    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean isUpdate;
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, user.getId());
        isUpdate = preparedStatement.executeUpdate() > 0;
        return isUpdate;
    }

    @Override
    public List<User> searchByAddress(String address) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USERS_ADDRESS);
            while (resultSet.next()) {
                if (resultSet.getString("country").equals(address)) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    userList.add(new User(id, name, email, country));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


}
