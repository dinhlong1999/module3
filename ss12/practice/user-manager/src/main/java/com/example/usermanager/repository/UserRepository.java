package com.example.usermanager.repository;

import com.example.usermanager.model.User;
import sun.dc.pr.PRError;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
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
    private static final String GET_USER_BY_ID = "{call get_user_by_id(?)};";
    private static final String INSERT_USER_STORE = "{call insert_user(?,?,?)};";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee(name,salary,created_Date)" +
            "VALUES(?,?,?);";
    private static final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET salary = ? where name = ? ";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    private static final String GET_ALL_USER_SP = "{call get_all_user()};";

    private static final String UPDATE_USER_SP = "{call edit_user(?,?,?,?)};";
    private static final String DELETE_USER_SP = "{call delete_user(?)};";

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

    @Override
    public User getUserById(int id) {
        User user = null;
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
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
    public void insertUserStore(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(INSERT_USER_STORE);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUserTransaction(User user, List<Integer> permissions) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatementAssignment = null;
        try {
            connection = BaseRepository.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int rowAffected = preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();
            int userld = 0;
            if (resultSet.next()) {
                userld = resultSet.getInt(1);
            }

            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(permision_id,user_id)"
                        + "values(?,?);";
                preparedStatementAssignment = connection.prepareStatement(sqlPivot);
                for (int permisionId : permissions) {
                    preparedStatementAssignment.setInt(1, permisionId);
                    preparedStatementAssignment.setInt(2, userld);
                    preparedStatementAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }

        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (preparedStatementAssignment != null) {
                    preparedStatementAssignment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection connection = BaseRepository.getConnection()) {
            Statement statement = connection.createStatement();
            PreparedStatement preparedInsert = connection.prepareStatement(SQL_INSERT_EMPLOYEE);
            PreparedStatement preparedUpdate = connection.prepareStatement(SQL_UPDATE_EMPLOYEE);
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            preparedInsert.setString(1, "Quynh");
            preparedInsert.setBigDecimal(2, new BigDecimal(10));
            preparedInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedInsert.execute();

            preparedInsert.setString(1, "Ngan");
            preparedInsert.setBigDecimal(2, new BigDecimal(20));
            preparedInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedInsert.execute();

//            preparedUpdate.setBigDecimal(2,new BigDecimal(999.99));
            preparedUpdate.setBigDecimal(1, new BigDecimal(999.99));
            preparedUpdate.setString(2, "Quynh");
            preparedUpdate.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = BaseRepository.getConnection()) {
            Statement statement = connection.createStatement();
//            PreparedStatement preparedInsert = connection.prepareStatement(SQL_INSERT_EMPLOYEE);
            PreparedStatement preparedUpdate = connection.prepareStatement(SQL_UPDATE_EMPLOYEE);
//            statement.execute(SQL_TABLE_DROP);
//            statement.execute(SQL_TABLE_CREATE);
//
//            connection.setAutoCommit(false);
//
//            preparedInsert.setString(1,"Quynh");
//            preparedInsert.setBigDecimal(2,new BigDecimal(10));
//            preparedInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
//            preparedInsert.execute();
//            preparedInsert.setString(1, "Ngan");
//            preparedInsert.setBigDecimal(2, new BigDecimal(20));
//            preparedInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//            preparedInsert.execute();
            preparedUpdate.setBigDecimal(1, new BigDecimal(999.99));

            preparedUpdate.setString(2, "Quynh");
            preparedUpdate.execute();

//            connection.commit();
//            connection.setAutoCommit(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUserStore() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_ALL_USER_SP);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void editUserStore(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USER_SP);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserStore(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER_SP);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUserTransaction(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

            connection.setAutoCommit(false);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
