package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		// Creation a Student Object
		Student student = new Student();

		student.setFirstName("Vinayak");
		student.setLastName("Naik");

		// Create an object of Certification
		Certification certificate = new Certification();

		certificate.setCourse("Java");
		certificate.setDuration("4 Months");

		student.setCertificate(certificate);

		session.save(student);

		Transaction tx = session.beginTransaction();
		
		tx.commit();

		session.close();

		sessionfactory.close();

	}
}
