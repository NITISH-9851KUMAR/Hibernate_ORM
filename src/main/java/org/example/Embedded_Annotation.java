package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embedded_Annotation {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        // First Student
        Student student= new Student(4, 23.33f, "Nitish");
        Certificate certificate= new Certificate("DAA", "6-Month");
        student.setCertificate(certificate);

        // Second Student
        Student student1= new Student(1, 35.33f, "Akash");
        Certificate certificate1= new Certificate("DBMS", "2-Month");
        student1.setCertificate(certificate1);

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        // Object Save
        session.save(student);
        session.save(student1);

        tx.commit();

        session.close();

        factory.close();

    }
}
