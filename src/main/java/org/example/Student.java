package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

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

