package org.cascading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        QuestionC question = new QuestionC(101, "DBMS");

        AnswerC a1 = new AnswerC(201, "Database Management System");
        a1.setQuestion(question);
        AnswerC a2 = new AnswerC(202, "Store Data Into DB");
        a2.setQuestion(question);
        AnswerC a3 = new AnswerC(203, "4th Generation Programming Language");
        a3.setQuestion(question);

        List<AnswerC> answerList = new ArrayList<>();
        answerList.add(a1);
        answerList.add(a2);
        answerList.add(a3);

        question.setAnswer(answerList);

        session.save(question);

//         If we don't use cascading then we manually save all answer
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);
//         if use cascading then we can prevent for save manually
//         use cascading in main entity class in this case Question

        tx.commit();

        session.close();
        factory.close();

    }

}
