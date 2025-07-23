package np.EmbeddedAnno;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        Person p1= new Person(1, "ABC", "Phulera");
        Person p2= new Person(2, "DEF", "Fakauli");

        Work w1= new Work("Police-Paint", "8 hours");
        Work w2= new Work("Painter", "8 hours");

        p1.setWork(w1);
        p2.setWork(w2);

        session.save(p1);
        session.save(p2);

        tx.commit();

        session.close();
        factory.close();

    }
}
