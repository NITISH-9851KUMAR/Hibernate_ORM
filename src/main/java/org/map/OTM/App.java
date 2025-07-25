package np.map.OTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Person p1 = new Person(501, "PM Modi");
        Person p2 = new Person(502, "Rahul Gandhi");

        Enemy e1 = new Enemy(701, "RJD");
        Enemy e2 = new Enemy(702, "SAPA");
        Enemy e3 = new Enemy(703, "JDU");
        Enemy e4 = new Enemy(704, "AAP");

        e1.setPerson(p1);
        e2.setPerson(p1);
        e3.setPerson(p2);
        e4.setPerson(p2);

        List<Enemy> enemyList1 = new ArrayList<>();
        enemyList1.add(e1);
        enemyList1.add(e2);

        List<Enemy> enemyList2 = new ArrayList<>();
        enemyList2.add(e3);
        enemyList2.add(e4);

        p1.setEnemy(enemyList1);
        p2.setEnemy(enemyList2);

        session.save(p1);
        session.save(p2);
        session.save(e1);
        session.save(e2);
        session.save(e3);
        session.save(e4);

        // Fetch Data
//        Person person= session.get(Person.class, 501);
//        System.out.println(person);
//
//        for(Enemy e: person.getEnemy()){
//            System.out.println(e);
//        }

        tx.commit();

        session.close();
        factory.close();
    }

}
