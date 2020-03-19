package com.niit.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class OneToManyMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sess = factory.openSession();
		sess.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAnswerName("HTML is used to create Static Web Page");
		ans1.setPostedBy("Raj gs");

		Answer ans2 = new Answer();
		ans2.setAnswerName("HTML is used for Web Designing");
		ans2.setPostedBy("John");

		Answer ans3 = new Answer();
		ans3.setAnswerName("Java SCript is a Scripting language");
		ans3.setPostedBy("Ram Kumar");

		Answer ans4 = new Answer();
		ans4.setAnswerName("JS is Client side Scripting language");
		ans4.setPostedBy("Arun");

		Answer ans5 = new Answer();
		ans5.setAnswerName("JS is client/server Scripting language");
		ans5.setPostedBy("Mike");

		ArrayList<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		ArrayList<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);
		list2.add(ans5);

		Question question1 = new Question();
		question1.setName("What is HTML?");
		question1.setAnswers(list1);

		Question question2 = new Question();
		question2.setName("What is Java Script?");
		question2.setAnswers(list2);

		sess.persist(question1);
		sess.persist(question2);

		sess.getTransaction().commit();

		// sess.close();
		System.out.println("Table Created & Record successfully Inserted");

	}

}
