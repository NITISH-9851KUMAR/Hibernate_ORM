package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Revision {
    public static void main(String[] args) {

        // Configure with cfg.xml file
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();


    }
}
