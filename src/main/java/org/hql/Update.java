package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Update {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Transaction tx= session.beginTransaction();

        // Delete value for table
        String q= "UPDATE Student set name='Nitish Kumar' WHERE id= 104";
        Query query= session.createQuery(q);
        int row= query.executeUpdate();
        System.out.println("Row Updated: "+row);

        tx.commit();

        session.close();
        factory.close();

    }
}
