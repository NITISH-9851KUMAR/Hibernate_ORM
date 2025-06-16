package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {

        // State of Hibernate
        // Transient state
        // Persistence state
        // Detached State
        // Removed State

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        // Creating Student Object
        Student student= new Student(004, 9.2f, "Nitish");
        student.setCertificate( new Certificate("DBMS", "2-Month"));
        // student Transient State

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(student);
        // student: Persistence State - session, database

        tx.commit();

        session.close();
        // student: Detached State

        System.out.println(student);

        session.remove(student);
        // Student : Removed State, After this we cannot fetch data


        factory.close();

    }
}
