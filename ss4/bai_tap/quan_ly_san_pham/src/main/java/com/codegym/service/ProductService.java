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
        Product product = new Product();
      List<Product> productList  =  productRepository.getAllProduct();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                product.setId(productList.get(i).getId());
                product.setName(productList.get(i).getName());
                product.setPrice(productList.get(i).getPrice());
                product.setDescribe(productList.get(i).getDescribe());
                product.setProducer(productList.get(i).getProducer());
                return product;
            }
        }
        return null;
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
