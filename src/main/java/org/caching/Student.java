package org.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int id; // Treated as column name in Table

    @Column(length=20)
    private String course; // Treated as column name in Table

    @Column(length=20)
    private String name; // Treated as column name in Table

    public Student(){} // Default Constructor

    public String toString(){
        return id+" "+name+" "+course;
    }

    public Student(int id, String name, String course){ // For value assign
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

        Student s1= new Student(106, "Yuvraj Kumar", "B.Tech");
        Student s2= new Student(107, "Kamalesh Kumar", "B.Tech");
        Student s3= new Student(108, "Manohar Kumar", "B.Tech");
        Student s4= new Student(109, "Asith Kumar", "B.Tech");
        Student s5= new Student(110, "Aditya Kumar", "B.Tech");
        Student s6= new Student(111, "Juber Kumar", "B.Tech");

        Transaction tx= session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);

        tx.commit();

        session.close();
        factory.close();
    }

}

