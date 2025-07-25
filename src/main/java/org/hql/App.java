package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

//import org.hql.Student;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String sql= "SELECT * FROM student";
        NativeQuery nq= session.createNativeQuery(sql);
        List<Object[]> list= nq.getResultList();
        for(Object[] l: list){
            System.out.println(Arrays.toString(l));
        }

        session.close();
        factory.close();

    }
}