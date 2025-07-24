package np.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;

import np.map.OTM.*;

import java.util.Arrays;
import java.util.List;


public class JoinQuery {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        String str= "SELECT p.personName, p.personId, e.enemyName from Person as p INNER JOIN p.enemy as e";
        Query query= session.createQuery(str);

        List<Object[]> list= query.getResultList();
        for(Object[] arr: list){
            System.out.println(Arrays.toString(arr));
        }

        session.close();
        factory.close();

    }
}
