package org.example;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Student{
    @Id
    private int id; // Treated as column name in Table

    @Column(length=20)
    private double marks; // Treated as column name in Table

    @Column(length=20)
    private String name; // Treated as column name in Table

    private Certificate certificate; // Declare Certificate Object

    public Certificate getCertificate(){
        return certificate;
    }

    public void setCertificate(Certificate certificate){
        this.certificate= certificate;
    }

    public Student(){} // Default Constructor

    public String toString(){
        float marks1= (int)marks;
        return id+" "+name+" "+marks1;
    }

    public Student(int id, float marks, String name){ // For value assign
        this.id= id;
        this.marks= marks;
        this.name= name;
    }

}

