package com.niit.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToOneForiegn {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sess = factory.openSession();
		sess.beginTransaction();

		Book newBook = new Book();
		newBook.setTitle("Hibernate Made Easy");
		newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
		newBook.setPublishedDate(new Date());

		newBook.setAuthor(new Author("Cameron Wallace McKenzie", "Cameron@gmail.com"));

		Long BookId = (Long) sess.save(newBook);

		Book book = (Book) sess.get(Book.class, BookId);
		System.out.println("Book's Title: " + book.getTitle());
		System.out.println("Book's Description: " + book.getTitle());

		Author author = book.getAuthor();
		System.out.println("Author's Name: " + author.getName());
		System.out.println("Author's Email: " + author.getEmail());

		sess.getTransaction().commit();
		sess.close();

	}

}
