package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;


public class SQLQuery {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();


        // SQL Query
        String q= "SELECT * FROM Student";
        NativeQuery nv= session.createNativeQuery(q);

        List<Object[]> list= nv.getResultList();
        for(Object[] student: list){
//            System.out.println(Arrays.toString(student)); // it Print All value
            System.out.println(student[1]+" "+student[2]); // it print only selective value
        }


        session.close();
        factory.close();

    }
}
