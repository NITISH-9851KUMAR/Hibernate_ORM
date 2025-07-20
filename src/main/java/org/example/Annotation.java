package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Entity // Make Address Class As Entity
@Table(name= "student_address") // Put the table name of Entity class as student_address
public class Annotation {

    @Id // Make column primary key
    @Column(name= "address_id") // column name
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    private int addressId;

    @Column(length= 20)
    private String street;

    @Column(length= 20)
    private String city;

    private boolean isOpen;

    @Transient // Transient means this columns will not create in Table
    private double x;

    @Column(name="add_date")
    @Temporal(TemporalType.DATE) // Modify the date add only date
    private Date addDate;

    @Lob // Large Object
    private byte[] image;

    public Annotation(){ // Default Constructor
        super();
    }


    public Annotation(String street, String city, boolean isOpen, double x, Date addDate, byte[] b) {
        // Parametrized Constructor
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addDate = addDate;
        this.image= b;
    }


    public static void main(String[] args) throws IOException {

        System.out.println("Project Started..");

        // Configure object of Hibernate.cfx.xml file
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        // Create the object of address class
        // Add photo
        FileInputStream fis= new FileInputStream("src/main/java/Mahadev.png");
        byte[] data_img= new byte[fis.available()];
        fis.read(data_img);

        // Create the object of address class
        Annotation address= new Annotation("Street_1", "Saharsa", true, 20.3, new Date(), data_img);

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(address);
        tx.commit();
        session.close();

        System.out.println("Done....");

    }
}
