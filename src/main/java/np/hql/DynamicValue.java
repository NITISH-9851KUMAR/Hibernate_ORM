package np.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

import np.Student;

import java.util.List;

public class RetrieveData {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // This is the part of Hibernate direct fetch using session.get() (not HQL)

        // it equivalent to "SELECT * FROM student WHERE id = 31004"
        // It uses the session API method get() or load()
        Student s = session.get(Student.class, 31004);
        System.out.println(s.getName());

        // This is part of HQL
        // Student is Class name not Table name
        // get Multiple value from the database
        StringBuilder str= new StringBuilder("from Student");
        Query query= session.createQuery(str.toString());
        List<Student> st= query.getResultList();
        for(Student student: st){
            System.out.println(student);
        }

        // get single value
        str.setLength(0);
        str.append("from Student WHERE id= 31004 and name= 'Nitish Kumar'");
//        str.append("from Student WHERE id=:x");

        query= session.createQuery(str.toString());
//        query.setParameter("x", 31004); also use this
        Student student= (Student)query.getSingleResult();
        System.out.println(student);


        session.close();
        factory.close();

    }
}
