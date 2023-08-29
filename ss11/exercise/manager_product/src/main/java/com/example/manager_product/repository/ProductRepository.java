package com.example.manager_product.repository;

import com.example.manager_product.model.Product;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT = "select * from product;";
    private static final String INSERT = "insert into product(`name`,price,`describe`,producer)\n" +
            "values (?,?,?,?);";
    private static final String UPDATE = "UPDATE `product` SET `name` = ? , `price` = ?, `describe` = ?, `producer` = ? WHERE (`id` = ?);";

    @Override
    public List<Product> showAll() {
        Connection connection = BaseRepository.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String describe = resultSet.getString("describe");
                String producer = resultSet.getString("producer");
                productList.add(new Product(id, name, price, describe, producer));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDescribe());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(int id, Product product) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setString(3,product.getDescribe());
            preparedStatement.setString(4,product.getProducer());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                if (resultSet.getString("name").contains(name)){
                    int id = resultSet.getInt("id");
                    String name1 = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    String describe = resultSet.getString("describe");
                    String producer = resultSet.getString("producer");
                    productList.add(new Product(id, name1, price, describe, producer));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                if (resultSet.getInt("id") == id){
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    String describe = resultSet.getString("describe");
                    String producer = resultSet.getString("producer");
                    product = new Product(id,name,price,describe,producer);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }


}
