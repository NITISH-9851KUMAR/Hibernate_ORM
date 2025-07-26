package org;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class CachingFirst {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Student s = session.get(Student.class, 31004);
        System.out.println(s);

        System.out.println("Working Something.....");

        // Use First Level Caching because we fetch data for same object
        // Hibernate first check if same object present in cache memory if yes then they don't hit database again
        // It is First level caching and valid till session.close(); method
        Student s1 = session.get(Student.class, 31004);
        System.out.println(s1);

        session.close();
        factory.close();

    }

}
