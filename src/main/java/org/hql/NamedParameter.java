package org.hql;

import org.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class NamedParameter {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        String str = "FROM Student WHERE name= :name";
        Query query = session.createQuery(str);
        query.setParameter("name", "Nitish Kumar");
        // Set the value for name is know as Dynamic value

        Student student = (Student) query.getSingleResult();
        System.out.println(student);

        session.close();
        factory.close();

    }
}
