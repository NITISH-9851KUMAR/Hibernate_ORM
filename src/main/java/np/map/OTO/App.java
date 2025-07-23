package np.map.OTO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        Question q1= new Question(101, "DBMS");
        Question q2= new Question(102, "JAVA");

        Answer a1= new Answer(301, "Database Management System");
        Answer a2= new Answer(302, "Just Another Virtual Accelerator");

        q1.setAnswer(a1);
        q2.setAnswer(a2);

        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);

        // fetch Details
//        Question question= session.get(Question.class, 101);
//        System.out.println(question);
//        System.out.println(question.getAnswer().toString());

        tx.commit();

        session.close();
        factory.close();

    }
}
