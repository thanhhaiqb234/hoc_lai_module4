package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"Rau cải",15000,"Hàng mới về","Cty Lâm AK"));
        productList.add(new Product(2,"Rau diếp cá",25000,"Hàng mới về","Cty Minh Lựu Đạn"));
        productList.add(new Product(3,"Rau xà lách",30000,"Hàng mới về","Cty Minh Nổ"));
    }



    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()){
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setDescribe(product.getDescribe());
                productList.get(i).setProducer(product.getProducer());
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id){
                productList.remove(productList.get(i));
                break;
            }
        }
    }

    @Override
    public void createProduct(Product product) {
        productList.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDescribe(), product.getProducer()));
    }

    @Override
    public List<Product> searchNameProduct(String name) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)){
                products.add(productList.get(i));
                break;
            } else if (name == "") {
                return productList;
            }
        }
        return products;
    }

    @Override
    public Product getProduct(int id) {
        Product product = new Product();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                product.setId(productList.get(i).getId());
                product.setName(productList.get(i).getName());
                product.setPrice(productList.get(i).getPrice());
                product.setDescribe(productList.get(i).getDescribe());
                product.setProducer(productList.get(i).getProducer());
            }
        }
        return product;
    }
}
