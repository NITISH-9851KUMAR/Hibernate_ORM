package np;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class CreateTable {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student s1= new Student(104, "Nitish", 'A');

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(s1);
        tx.commit();

        session.close();

    }
}
