/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author abhi
 */
public class CategoryModel {

    SessionFactory sessionFactory;
    Session session;

    public CategoryModel() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();

    }

    public Category saveCategory(Category c) {
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();

        return c;
    }

    public List<Category> getCategories() {
        Criteria createCriteria = session.createCriteria(Category.class);
        return createCriteria.list();
    }
    
    
    public static void main(String[] args) {
        List<Category> messages = new CategoryModel().getCategories();
        System.out.println(messages.get(0).getCategory());
    }
    
}
