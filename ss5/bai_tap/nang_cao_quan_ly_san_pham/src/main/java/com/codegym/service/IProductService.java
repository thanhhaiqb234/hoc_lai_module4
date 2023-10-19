package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    Product getProduct(int id);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);
}
