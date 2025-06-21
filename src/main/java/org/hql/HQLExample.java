package org.hql;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import javax.persistence.Query;


public class HQLExample {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        // hql Query
        // select data from table

        // Fetching all details from table
//        String q= "FROM StudentH";
//        Query query= session.createQuery(q);
//
//        List<StudentH> s=  query.getResultList();
//
//        for(StudentH list: s){
//            System.out.println(list);
//        }

        // Fetching single details from table
        // with dynamic value from user
        String q= "from Student WHERE name= :val AND id= :id";
        // For Dynamic value
        Query query= session.createQuery(q);
        query.setParameter("val", "Nitish");
        query.setParameter("id", 104);

    try{
        Student student= (Student) query.getSingleResult();
        System.out.println(student);
    }catch(javax.persistence.NoResultException e){
        System.out.println("No Result Found");
    }


        session.close();
        factory.close();

    }
}
