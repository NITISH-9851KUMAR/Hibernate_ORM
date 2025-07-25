package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Update {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String str = "UPDATE Student SET grade= :grade WHERE id= :id";
        Query query = session.createQuery(str);
        query.setParameter("grade", 'A');
        query.setParameter("id", 31002);

        query.executeUpdate();
        System.out.println("Update Table Successfully");

        session.close();
        factory.close();

    }
}
