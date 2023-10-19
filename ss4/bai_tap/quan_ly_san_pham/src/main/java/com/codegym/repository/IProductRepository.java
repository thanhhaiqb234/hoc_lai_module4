package com.codegym.repository;

import com.codegym.model.Product;

import java.awt.*;
import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    void updateProduct(Product product);

    void edleteProduct(int id);

    void createProduct(Product product);

    List<Product> searchNameProduct(String name);

    Product getProduct(int id);
}
