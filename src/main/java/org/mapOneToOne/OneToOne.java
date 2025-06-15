package org.mapOneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class OneToOne {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();


        Answer a1= new Answer(501, "Java is a Programming Language");
        Question q1= new Question(101, "What is Java ?", a1);
        a1.setQuestion(q1);

        Answer a2= new Answer(502, "Python is Programming Language");
        Question q2= new Question(102, "What is Python ?", a2);
        a2.setQuestion(q2);

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);

        tx.commit();

        // Fetch Question with answer
        Question newQ= session.get(Question.class, 101);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer());

        session.close();
        factory.close();

    }
}
