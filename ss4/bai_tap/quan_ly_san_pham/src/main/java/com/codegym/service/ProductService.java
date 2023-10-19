package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product getProduct(int id) {
      return productRepository.getProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
     }

    @Override
    public void deleteProduct(int id) {
        productRepository.edleteProduct(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public List<Product> searchNameProduct(String name) {
        return productRepository.searchNameProduct(name);
    }
}
