package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.mapOneToMany.Answer;
import org.mapOneToMany.Question;

import java.util.ArrayList;
import java.util.List;



public class CascadingExample {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Question q= new Question(102, "What is Python?");
        Answer a1= new Answer(601, "Just Another Virtual Accelerator");
        Answer a2= new Answer(602, "Programming Language");
        Answer a3= new Answer(603, "Object Oriented Language");

        List<Answer> list= new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q.setAnswer(list);

        Transaction tx= session.beginTransaction();

        session.save(q);
        // I want to when i save my question then automatically save my answer
        // For doing this use cascading method

        // These are manually save
        // We can use cascading to avaoid this
        // cacading is used in Question class mapOneToMany package
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);

        tx.commit();


        session.close();
        factory.close();

    }
}
