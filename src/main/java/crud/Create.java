package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name= "Student")
public class Create {

    @Id
    @Column(length= 3)
    int id;

    @Column(length= 20)
    String name;

    @Column(length= 20)
    String course;

    public Create(){}

    public Create(int id, String name, String course){
        this.id= id;
        this.name= name;
        this.course= course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return id+"  "+name+"  "+course;
    }

    public static void main(String[] args) {

        Configuration cfg= new Configuration();
        cfg.configure("hibernate2.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();

        Create obj1= new Create(104, "Nitish Kumar", "B.Tech");
        Create obj2= new Create(105, "Himanshu Kumar", "B.Tech");
        Create obj3= new Create(106, "Yuvraj Kumar", "B.Tech");

        session.save(obj1);
        session.save(obj2);
        session.save(obj3);
        Transaction tx= session.beginTransaction();
        tx.commit();

        session.close();
        factory.close();

    }

}
