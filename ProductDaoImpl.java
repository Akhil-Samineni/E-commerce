package com.emusicstore.Dao;

import com.emusicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        //only when we flush it the session operations will be executed
        session.flush();

    }

    public void editProduct(Product product) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        //only when we flush it the session operations will be executed
        session.flush();

    }

    public Product getProductById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Product product=(Product) session.get(Product.class,id);
        session.flush();
        return product;
    }

    public List<Product> getAllProducts() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery(" from Product");
        List<Product> productList=query.list();
        session.flush();
         return productList;
    }

    public void deleteProduct(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();

    }
}
