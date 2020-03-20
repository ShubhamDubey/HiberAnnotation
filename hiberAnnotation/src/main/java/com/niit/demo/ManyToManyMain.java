package com.niit.demo;

import java.util.HashSet;
import java.util.Set;
import static java.lang.System.out;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManyToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Item item1 = new Item();
			item1.setDescription("Samsung");
			item1.setPrice(300);
			Item item2 = new Item();
			item2.setDescription("Nokia");
			item2.setPrice(200);

			Cart cart1 = new Cart();
			cart1.setTotal(500);
			HashSet<Item> itemSet1 = new HashSet<Item>();
			itemSet1.add(item1);
			itemSet1.add(item2);
			cart1.setItems(itemSet1);
			session.persist(cart1);
			session.getTransaction().commit();
			System.out.println("Sucessfully Run");

			System.out.println("****Cart Items*****");
			System.out.println("Cart ID=" + cart1.getId());
			out.println("Item1 ID=" + item1.getId());
			out.println("Product=" + item1.getDescription());
			out.println("Price=" + item1.getPrice());

			out.println("Item2 ID=" + item2.getId());
			out.println("Product=" + item2.getDescription());
			out.println("Price=" + item2.getPrice());
			out.println("****Cart Items*****");
			out.println("Cart ID=" + cart1.getId());
			out.println("Item1 ID=" + item1.getId());
			out.println("Product=" + item1.getDescription());
			out.println("Price=" + item1.getPrice());

			out.println("Item2 ID=" + item2.getId());
			out.println("Product=" + item2.getDescription());
			out.println("Price=" + item2.getPrice());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}