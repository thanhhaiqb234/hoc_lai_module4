package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    Product getProduct(int id);

    void createProduct(Product product);

    void updateProruct(Product product);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);
}
