package org.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hql.Student;

import java.util.List;

public class Criteria {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        Session session= factory.openSession();

        Criteria c= (Criteria) session.createCriteria(Student.class);
        List<Student> list= c.list();


        session.close();
        factory.close();

    }
}
