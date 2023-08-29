package com.example.manager_product.repository;

import com.example.manager_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();
    void saveProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    List<Product> findByName(String name);
    Product findById(int id);

}
