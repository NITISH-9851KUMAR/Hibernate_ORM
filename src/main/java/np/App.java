package np;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate3.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        // For annotation class

        Annotation st= new Annotation(1, "Saharsa", true);
        st.setAddDate(new Date());
        FileInputStream fis= new FileInputStream("D:\\Photo_All\\Screenshots\\Puzzle.jpg");
        byte[] img= new byte[fis.available()];
        fis.read(img);
        st.setImage(img);
        fis.close();
        session.save(st);


        session.close();
        factory.close();
    }
}
