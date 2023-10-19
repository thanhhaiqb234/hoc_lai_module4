package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> query = entityManager.createQuery("select P from Product as P", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProduct(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void updateProruct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProduct(id);
        entityManager.remove(getProduct(product.getId()));
    }

    @Override
    public List<Product> searchProduct(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p where p.name like :name",Product.class);
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }

}
