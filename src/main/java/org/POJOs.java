// A POJOs class is simple java Class. It does not extend or implements any class or interface.
// It contains only fields, constructor, setter and getter. It is used to map to a database table in
// Object-Relational Mapping

package org;

public class POJOs {

    int id;
    String name;
    float marks;
    char grade;

    public POJOs(int id, String name, float marks, char grade) {
        this.id = id;
        this.name = name;
        this.marks = marks;
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

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
