package com.example.manager_product.service;

import com.example.manager_product.model.Product;
import com.example.manager_product.repository.IProductRepository;
import com.example.manager_product.repository.ProductRepository;

import java.util.List;

public class ProductService implements  IProductService {
    private static IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> showAll() {
        return productRepository.showAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(int id) {
    productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(int id) {
       return productRepository.findById(id);
    }
}
