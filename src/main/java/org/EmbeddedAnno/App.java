package org.EmbeddedAnno;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        PersonE p1 = new PersonE(1, "ABC", "Phulera");
        PersonE p2 = new PersonE(2, "DEF", "Fakauli");

        Work w1 = new Work("Police-Paint", "8 hours");
        Work w2 = new Work("Painter", "8 hours");

        p1.setWork(w1);
        p2.setWork(w2);

        session.save(p1);
        session.save(p2);

        // Session Api Fetch Technique
//        PersonE person= session.get(PersonE.class, 1);
//        System.out.println(person);
//        System.out.println(person.getWork());

        // HQL Fetch Technique
//        String hql= "FROM PersonE";
//        Query query= session.createQuery(hql);
//        List<PersonE> list= query.getResultList();
//        for(PersonE e: list){
//            System.out.println(e);
//            System.out.println(e.getWork());
//        }

        tx.commit();

        session.close();
        factory.close();

    }
}
