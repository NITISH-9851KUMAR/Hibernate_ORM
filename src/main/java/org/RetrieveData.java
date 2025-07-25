package org;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class RetrieveData {
    public static void main(String[] args) {

        // Fetch Data
       Configuration cfg= new Configuration();
       cfg.configure("hibernate_mysql.cfg.xml");
       SessionFactory factory= cfg.buildSessionFactory();
       Session session= factory.openSession();

       Student student= session.get(Student.class, 31004);
       System.out.println(student);

       session.close();
       factory.close();

    }
}
