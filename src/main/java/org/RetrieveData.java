package np;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class RetrieveData {
    public static void main(String[] args) {

        // Fetch Data
       Configuration cfg= new Configuration();
       cfg.configure("hibernate3.cfg.xml");
       SessionFactory factory= cfg.buildSessionFactory();
       Session session= factory.openSession();

       Student student= session.get(Student.class, 104);
       System.out.println(student);

       session.close();
       factory.close();

    }
}
