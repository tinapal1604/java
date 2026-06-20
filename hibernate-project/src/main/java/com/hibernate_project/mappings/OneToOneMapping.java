package com.hibernate_project.mappings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txc = session.beginTransaction();
		
		//create passport
		Passport pas1 = new Passport("AS1001");
		Passport pas2 = new Passport("PP1002");
		Passport pas3 = new Passport("RV1003");
		Passport pas4 = new Passport("SR1004");
		Passport pas5 = new Passport("VS1005");
		List<Passport> pasList = new ArrayList<Passport>(Arrays.asList(pas1,pas2, pas3, pas4, pas5));
		
		for(Passport p: pasList) {
			session.save(p);
		}
		
		//create persons
		Person person1 = new Person("Arjun Sharma", pas1);
        Person person2 = new Person("Priya Patel", pas2);
        Person person3 = new Person("Rahul Verma", pas3);
        Person person4 = new Person("Sneha Reddy", pas4);
        Person person5 = new Person("Vikram Singh", pas5);
        List<Person> personList = new ArrayList<Person>(Arrays.asList(person1, person2, person3, person4, person5));
        
        for(Person p: personList) {
        	session.save(p);
        }
		
		txc.commit();
		session.close();
		factory.close();
		System.out.println("saved successfully....");
	}

}
