package caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
@Table(name= "Student2")
public class StudentCache {
    @Id
    private int id; // Treated as column name in Table

    @Column(length=20)
    private String course; // Treated as column name in Table

    @Column(length=20)
    private String name; // Treated as column name in Table

    public StudentCache(){} // Default Constructor

    public String toString(){
        return id+" "+name+" "+course;
    }

    public StudentCache(int id, String name, String course){ // For value assign
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

        StudentCache s1= new StudentCache(104, "Nitish Kumar", "B.Tech");

        Transaction tx= session.beginTransaction();
        session.save(s1);
        tx.commit();

        session.close();
        factory.close();
    }
}

