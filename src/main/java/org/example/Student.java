package org.example;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Student{
    @Id
    private int id; // Treated as column name in Table

    @Column(length=20)
    private float marks; // Treated as column name in Table

    @Column(length=20)
    private String name; // Treated as column name in Table

    public Student(){ // Default Constructor

    }

    public Student(int id, float marks, String name){ // For value assign
        this.id= id;
        this.marks= marks;
        this.name= name;
    }

}

