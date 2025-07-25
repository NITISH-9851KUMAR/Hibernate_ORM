package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CachingSecond {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        // First
        Session session1= factory.openSession();
        Student student= session1.get(Student.class, 31009);
        System.out.println(student);
        session1.close();

        // Second
        Session session2= factory.openSession();
        Student student2= session2.get(Student.class, 31009);
        System.out.println(student2);
        session2.close();


        factory.close();

    }
}
