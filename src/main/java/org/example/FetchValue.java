package org.example;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class FetchValue {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        // For fetch value from database use get, load method
        // get the value of Student table id is 4

        InsertValue objValue= session.get(InsertValue.class, "Nitish");
        System.out.println(objValue.getId());
        System.out.println(objValue.getName());
        System.out.println(objValue.getGrade());
        // Instead of get we can also use load
        // InsertValue objValue= session.get(InsertValue.class, 4);

        session.close();
        factory.close();

    }
}
