package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

public class CachingSecond {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        // For Second level Caching first add dependency in pom.xml file
        // Also add some property in hibernate.org.xml file
        // Second Level Cache use on SessionFactory level

        // First Session
        Session session1= factory.openSession();
        Student s1= session1.get(Student.class, 31004);
        System.out.println(s1);
        session1.close();

        // Second Session
        Session session2= factory.openSession();
        Student s2= session2.get(Student.class, 31004);
        System.out.println(s2);
        session2.close();

        factory.close();

    }
}
