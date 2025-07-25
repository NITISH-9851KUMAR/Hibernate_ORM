package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.map.OTM.Person;

public class LazyLoading {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // The person class is situated in ma.OTM class
        Person person = session.get(Person.class, 501);

        // It is by default Lazy Loading
        System.out.println(person);
        // When we get the size of enemy then it executes enemy sql query
        // Before it doesn't execute any sql query,  it is lazy loading
        System.out.println(person.getEnemy().size());

//        When we explicitly set the property Eager in mappedType Type then
//        it automatically execute sql query for answer table when we only show the answer
//        System.out.println(person);
//        System.out.println(p.getEnemy().size());

        session.close();
        factory.close();

    }
}
