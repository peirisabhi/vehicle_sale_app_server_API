/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import entity.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author abhi
 */
public class ProductModel {

    SessionFactory sessionFactory;
    Session session;

    public ProductModel() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

    }

    public Product  saveProduct(Product p) {
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();

        return p;
    }

    public List<Product> getAllProducts() {
        Criteria createCriteria = session.createCriteria(Category.class);
        return createCriteria.list();
    }

    public List<Product> getProductsByCategory(int categoryId) {
        
        Category category = (Category) session.get(Category.class, categoryId);
        
        Criteria createCriteria = session.createCriteria(Product.class);
        createCriteria.add(Restrictions.eq("category", category));
        return createCriteria.list();
    }
    
    
    public static void main(String[] args) {
        List<Product> productsByCategory = new ProductModel().getProductsByCategory(2);
        for (Product p : productsByCategory) {
            System.out.println(p.getProductName()+ " " + p.getCategory().getCategory());
        }
    }


}
