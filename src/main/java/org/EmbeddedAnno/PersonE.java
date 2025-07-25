package org.EmbeddedAnno;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "person_emb")
public class PersonE {

    @Id
    private int emp_id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String home;

    private Work work;

    public PersonE() {
    }

    public PersonE(int emp_id, String name, String home) {
        this.emp_id = emp_id;
        this.name = name;
        this.home = home;
    }

    public void setWork(Work w) {
        this.work = w;
    }

    public Work getWork() {
        return this.work;
    }

    public String toString(){
        return emp_id+" "+name+" "+home;
    }

}
