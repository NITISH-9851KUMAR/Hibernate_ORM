package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Pagination {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        String q= "FROM Student";
        Query query= session.createQuery(q);

        // implementing pagination
        // pagination-> means print the result between a range value

        query.setFirstResult(4); // starting point
        query.setMaxResults(2); // Number of value(result) basically how much value we want

        List<Student> s= query.getResultList();
        for(Student list: s)
            System.out.println(list);

        session.close();
        factory.close();

    }
}
