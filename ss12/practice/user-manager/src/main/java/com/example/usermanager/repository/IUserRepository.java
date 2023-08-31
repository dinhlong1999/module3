package com.example.usermanager.repository;

import com.example.usermanager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    void deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchByAddress(String address);
    User getUserById(int id);
    void insertUserStore(User user);
    void addUserTransaction(User user, List<Integer> permission);
    void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
    List<User> getAllUserStore ();

    void editUserStore(User user);
    void deleteUserStore(int id);

    void insertUserTransaction(User user);


}
