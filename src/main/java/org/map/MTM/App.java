package org.map.MTM;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee(101, "Akash Kumar");
        Employee e2 = new Employee(102, "Ankush Kumar");
        Employee e3 = new Employee(103, "Nitish Kumar");

        Project p1 = new Project(1, "Bank Management System");
        Project p2 = new Project(2, "E-Commerce Website");
        Project p3 = new Project(3, "Online Shopping");

        //work Assign
        // e2 -> p1
        // e3 -> p1
        // e3 -> p2

        List<Project> projects = new ArrayList<>();
        projects.add(p1);
        projects.add(p2);

        List<Employee> employees = new ArrayList<>();
        employees.add(e2);
        employees.add(e3);

        p1.setEmployee(employees);
        e3.setProjects(projects);

        session.save(e1);
        session.save(e2);
        session.save(e3);
        session.save(p1);
        session.save(p2);
        session.save(p3);

        tx.commit();

        session.close();
        factory.close();
    }

}
