package org;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaClass {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Criteria criteria= session.createCriteria(Student.class);

        // Add the restrictions for filtering data using criteria class
//        criteria.add(Restrictions.eq("id", 31005));
//        criteria.add(Restrictions.gt("id", 31005));
        criteria.add(Restrictions.like("name", "A%")); // Filter all name which starts with A

        List<Student> st= criteria.list();
        for(Student student: st){
            System.out.println(student);
        }

        session.close();
        factory.close();
    }
}
