package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Delete {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Transaction tx= session.beginTransaction();

        // Delete value for table
        String q= "DELETE FROM Student WHERE id= :id";
        Query query= session.createQuery(q);
        query.setParameter("id", 106);

        int val= query.executeUpdate();
        tx.commit();
        System.out.println("Deleted Column: "+val);

        session.close();
        factory.close();

    }
}
