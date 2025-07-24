package np;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import java.util.Arrays;
import java.util.List;

import org.hql.Student;

public class SQLQuery {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        String query= "SELECT * FROM student";

        NativeQuery nq= session.createSQLQuery(query);
        List<Object[]> results= nq.getResultList();

        for(Object[] student: results){
            System.out.println(student[0]+ " "+student[2]);
        }

        session.close();
        factory.close();

    }
}
