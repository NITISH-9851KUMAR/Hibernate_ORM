package org;

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
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setId(31009);
        student.setName("Aditya");
        student.setGrade('I');
        student.setExamMarks(90.3);

        // When we set the property of student object
        // student -> Transient State
        // Associated with -> database: No , Session: No

        session.save(student);
        // student -> Persistent State
        // Associated With -> Database: Yes , Session: Yes

        student.setName("Aditya Raj");
        // It will now work because object associated with Database and Session
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
