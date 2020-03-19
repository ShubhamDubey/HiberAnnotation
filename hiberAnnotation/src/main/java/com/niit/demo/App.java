package com.niit.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Configuration cfg=new Configuration();
      cfg.configure("hibernate.cfg.xml");
      SessionFactory factory=cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
      Session sess=factory.openSession();
      sess.beginTransaction();
      Employee e1=new Employee();
      e1.setId(105);
      e1.setFirstName("Deepanshu");
      e1.setLastName("Gupta");
      sess.save(e1);
      sess.getTransaction().commit();
      sess.close();
      factory.close();
      
    }
}
