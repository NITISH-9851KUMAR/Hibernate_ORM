package org.mapOneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

//        Question q= new Question(101, "What is Java?");
//
//        Answer a= new Answer(501, "Just another Virtual Accelerator");
//        a.setQuestion(q);
//
//        Answer a1= new Answer(502, "Java is Programming Language");
//        a1.setQuestion(q);
//
//        Answer a2= new Answer(503, "Java is Programming Language");
//        a2.setQuestion(q);
//
//        List<Answer> list= new ArrayList<>();
//        list.add(a);
//        list.add(a1);
//        list.add(a2);
//
//        q.setAnswer(list);

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

//        session.save(q);
//        session.save(a);
//        session.save(a1);
//        session.save(a2);
//
//        tx.commit();

        // Fetch Data

        Question q= session.get(Question.class, 101);
        System.out.println(q);

//        System.out.println(q.getAnswer().size());

//        for(Answer a: q.getAnswer()){
//            System.out.println(a.getAnswer());
//        }

        session.close();
        factory.close();
    }
}
