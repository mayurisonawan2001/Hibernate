package org.sample.mavensample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sample.mavensample.Student;

public class App
{
    public static void main( String[] args )
    {
    	System.out.println("Project started!");

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Make sure file is in src/main/resources
                .buildSessionFactory();

        System.out.println(factory);
        System.out.println(factory.isClosed());

        Student st = new Student(1010, "Mayuri", "Dhule");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(st);
        tx.commit();

        session.close();
        factory.close();
        
        
    }
}
