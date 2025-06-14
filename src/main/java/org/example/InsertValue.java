package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

@Entity
@Table(name="Bagmati2")
public class InsertValue {

    @Id
    @Column(length= 3)
    private int id;

    @Column(length= 20)
    private String name;

    @Column(length= 2)
    private char grade;

    public InsertValue(){
    }

    @Override
    public String toString() { // Return the object value
        return  +id+"  "+name+ "  "+grade;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public char getGrade(){
        return grade;
    }


    public InsertValue(int id, String name, char grade){
        this.id= id;
        this.name= name;
        this.grade= grade;
    }

    public static void main(String[] args) {

        Configuration cfg= new Configuration(); // Configure to cfg.xml file
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        InsertValue obj= new InsertValue(004, "Nitish", 'a');
        InsertValue obj2= new InsertValue(001, "Aakash", 'b');
        InsertValue obj3= new InsertValue(002, "Divyanshu", 'c');
        InsertValue obj4= new InsertValue(003, "Ankush", 'd');

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(obj);
        session.save(obj2);
        session.save(obj3);
        session.save(obj4);
        tx.commit();

        session.close();

        System.out.println("Valued Saved successfully...");

    }

}
