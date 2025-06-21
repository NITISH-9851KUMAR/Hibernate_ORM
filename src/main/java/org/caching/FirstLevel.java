package org.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hql.Student;

import javax.persistence.Query;
import java.util.List;

public class FirstLevel {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Student s= session.get(Student.class, 104);
        System.out.println(s);

        // Now comes the role of FirstLevel caching
        // When session has same type of value for fetching details, above we fetch to 104 again we fetch 104 id
        // Then they don't hit the data again, show the value into from session

        Student s1= session.get(Student.class, 104);
        System.out.println(s1);
        // So printing the value of s1 they simply print value from his session store data
        // This is First Level Caching

        session.close();
        factory.close();


    }
}
