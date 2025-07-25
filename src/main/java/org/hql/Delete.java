package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class Delete {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate._mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx= session.beginTransaction();

        String str= "DELETE FROM Student WHERE grade= :grade";
        Query query= session.createQuery(str);
        query.setParameter("grade", 'E');

        // this method execute the query and it returns integer value
        int rowAffect= query.executeUpdate();
        System.out.println("Deleted Successfully : "+rowAffect);

        tx.commit();

        session.close();
        factory.close();

    }
}
