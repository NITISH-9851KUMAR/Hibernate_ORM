package org.xmlMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.map.OTO.Answer;
import org.map.OTO.Question;

public class App {

    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        Room room= new Room(10, 30, "White", "Raman Kumar Jain");
        session.save(room);

        tx.commit();


        session.close();
        factory.close();
    }
}
