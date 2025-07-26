package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;

@Entity
@Table(name= "StudentBatch")
public class BatchProcessing {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;
    private String address;

    public BatchProcessing(){}

    public BatchProcessing(String name, String course, String address){
        this.name= name;
        this.course= course;
        this.address= address;
    }

    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        for(int i= 1; i<=5000; i++){
            String name= "name_"+i;
            String course= "course_"+i;
            String address= "address_"+i;
            BatchProcessing batch= new BatchProcessing(name, course, address);
            session.save(batch);

            if(i%20== 0){  // batch size
                session.flush();
                session.clear();
            }
        }

        tx.commit();

        session.close();
        factory.close();

    }

}
