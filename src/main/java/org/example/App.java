package org.example;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Project Started..");

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        Student s1= new Student(004, 9.2f, "Nitish");
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(s1);

        tx.commit();
        session.close();

    }
}
