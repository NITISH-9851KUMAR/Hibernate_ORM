package org;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Cacheable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Student")
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class    Student {

    @Id
    private int id;

    @Column(length= 20)
    private String name;

    @Column(length= 1)
    private char grade;

    @Column(name= "mark")
    private double examMarks;

    public Student(){
    }

    public Student(int id, String name, char grade, double examMarks) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.examMarks= examMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public double getExamMarks() {
        return examMarks;
    }

    public void setExamMarks(double examMarks) {
        this.examMarks = examMarks;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+grade+" "+examMarks;
    }
}
