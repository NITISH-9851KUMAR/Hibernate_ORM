package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentH {
    @Id
    private int id; // Treated as column name in Table

    @Column(length=20)
    private String course; // Treated as column name in Table

    @Column(length=20)
    private String name; // Treated as column name in Table

    public StudentH(){} // Default Constructor

    public String toString(){
        return id+" "+name+" "+course;
    }

    public StudentH(int id, String name, String course){ // For value assign
        this.id= id;
        this.course= course;
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        StudentH s1= new StudentH(104, "Nitish", "B.Tech");
        StudentH s2= new StudentH(105, "Himanshu", "B.Tech");
        StudentH s3= new StudentH(106, "Yuvraj", "B.Tech");

        Transaction tx= session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.save(s3);

        tx.commit();

        session.close();
        factory.close();
    }

}

