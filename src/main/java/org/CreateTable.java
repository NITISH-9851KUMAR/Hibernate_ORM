package org;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class CreateTable {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        Student s1= new Student(31001, "Akash Kumar", 'A', 90.3);
        Student s2= new Student(31002, "Divyanshu Roy", 'B', 90.3);
        Student s3= new Student(31003, "Ankush Raj", 'C', 90.3);
        Student s4= new Student(31004, "Nitish Kumar", 'D', 90.3);
        Student s5= new Student(31005, "Himanshu Kumar", 'E', 90.3);
        Student s6= new Student(31006, "Yubraj Kumar", 'F', 90.3);
        Student s7= new Student(31007, "Kamalesh Kumar", 'G', 90.3);
        Student s8= new Student(31008, "Manohar Kumar", 'H', 90.3);

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);
        session.save(s8);

        tx.commit();

        session.close();
        factory.close();

    }
}
