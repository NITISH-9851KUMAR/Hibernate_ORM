package np;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="Student2")
public class    Student {

    @Id
    private int id;

    @Column(length= 20)
    private String name;

    @Column(length= 1)
    private char grade;

    public Student(){

    }

    public Student(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public String toString(){
        return this.id+" "+this.name+" "+this.grade;
    }

}
