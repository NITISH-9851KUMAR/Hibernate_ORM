package np;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifecycleState {
    public static void main(String[] args) {

        // Transient State
        // Persistent State
        // Detached State
        // Removed State
        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setId(31004);
        student.setName("Nitish");
        student.setGrade('P');
        // When we set the property of student object
        // student -> Transient State
        // Associated with -> database: No , Session: No

        session.save(student);
        // student -> Persistent State
        // Associated With -> Database: Yes , Session: Yes

        student.setName("Nitish Kumar");

        tx.commit();

        session.close();
        // student -> Detached State
        // Associated With -> Database: Yes , Session: no
        // If we set now the value of object will not save. because it is not associated with session
        student.setName("Kumar");

        // session.delete(student);
        // student -> Removed State
        // Associated With -> Database: No , Session: Yes

        factory.close();

    }
}
