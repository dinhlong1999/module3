package com.example.usermanager.service;

import com.example.usermanager.model.User;
import com.example.usermanager.repository.IUserRepository;
import com.example.usermanager.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUsersService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
     userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchByAddress(String address) {
        return userRepository.searchByAddress(address);
    }

    @Override
    public User getUserById(int id) {
       return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, List<Integer> permission) {
        userRepository.addUserTransaction(user,permission);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }

    @Override
    public List<User> getAllUserStore() {
        return  userRepository.getAllUserStore();
    }
    public void editUserStore(User user){
        userRepository.editUserStore(user);
    }

    @Override
    public void deleteUserStore(int id) {
        userRepository.deleteUserStore(id);
    }
    public void insertUserTransaction(User user){
        userRepository.insertUserTransaction(user);
    }
}
