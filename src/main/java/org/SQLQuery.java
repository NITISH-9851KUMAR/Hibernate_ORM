package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import java.util.List;
import java.util.Arrays;

public class SQLQuery {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate_mysql.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        String sql= "SELECT * FROM student"; // student is table name , not any Class/Entity name
        NativeQuery query= session.createNativeQuery(sql);
        List<Object[]> list= query.list();
        for(Object[] obj: list){
            System.out.println(Arrays.toString(obj));
        }

        session.close();
        factory.close();

    }
}
