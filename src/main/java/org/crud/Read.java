package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        // Fetch Data for single Student
//        Create student1= session.get(Create.class, 104);
        //        System.out.println(student1);

        // Fetching all Details
        Query query= session.createQuery("From Create");
        List<Create> list= query.getResultList();
        for(Create c: list){
            System.out.println(c);
        }

        session.close();
        factory.close();

    }
}
