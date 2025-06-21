package caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        Session session1= factory.openSession();
        StudentCache s= session1.get(StudentCache.class, 104);
        System.out.println(s);
        session1.close();

        Session session2= factory.openSession();
        StudentCache s1= session1.get(StudentCache.class, 104);
        System.out.println(s1);
        session2.close();


        factory.close();


    }
}
