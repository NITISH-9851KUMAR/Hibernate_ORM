//package org.hql;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import javax.persistence.Query;
//import java.util.List;
//
//import org.hql.Student;
//
//public class Pagination {
//    public static void main(String[] args) {
//
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate_mysql.cfg.xml");
//        SessionFactory factory = cfg.buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        String hql = "FROM Student";
//        Query query = session.createQuery(hql);
//
//        // Pagination
//        query.setFirstResult(3); // set first position
//        query.setMaxResults(3);  // Number of Object
//
//        List<Student> results = query.getResultList();
//        for (Student student : results) {
//            System.out.println(student);
//        }
//
//        session.close();
//        factory.close();
//
//    }
//}
