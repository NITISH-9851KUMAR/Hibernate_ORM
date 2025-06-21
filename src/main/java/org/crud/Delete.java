package org.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        System.out.print("Enter ID: ");
        int id= new java.util.Scanner(System.in).nextInt();

        Create st1= session.get(Create.class, id);

        Transaction tx= session.beginTransaction();
        session.delete(st1);
        tx.commit();

        session.close();
        factory.close();
    }
}
