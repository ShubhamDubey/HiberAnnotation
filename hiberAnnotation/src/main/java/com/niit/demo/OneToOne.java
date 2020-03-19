package com.niit.demo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sess = factory.openSession();
		sess.beginTransaction();

		Customer c1 = new Customer();
		c1.setName("John");
		c1.setEmail("John@gmail.com");

		Address address1 = new Address();
		address1.setAddressLine1("#101 Sunrise WOODS");
		address1.setCity("Mum");
		address1.setState("Maharastra");
		address1.setCountry("INDIA");
		address1.setPincode(124501);

		c1.setAddress(address1);
		address1.setCustomer(c1);

		sess.persist(c1);
		sess.getTransaction().commit();

		System.out.println("Table Created & Record successfully Inserted");

		System.out.println("*********** Display Data ************");
		TypedQuery<Customer> query = sess.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();

		Iterator<Customer> itr = list.iterator();
		while (itr.hasNext()) {
			Customer cust = itr.next();
			System.out.println(cust.getCustomerId() + " " + cust.getName() + " " + cust.getEmail());
			Address address = cust.getAddress();
			System.out.println(address.getAddressLine1() + " " + address.getCity() + " " + address.getState() + " "
					+ address.getCountry() + " " + address.getPincode());
		}
		sess.close();
		System.out.println("success");

	}

}
