package com.hibernate_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchRecordFromDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction txc = session.beginTransaction();
		
		//get method returns null when record not found in database
		Student s = session.get(Student.class, 1003);
		System.out.println(s);
		
		Student s2 = session.get(Student.class, 1000);
		System.out.println(s2);
		
		//load method returns object not found exception instead of null
		Student s3 = session.load(Student.class, 1004);
		System.out.println(s3);
		
		Student s4 = session.load(Student.class, 1000);
		System.out.println(s4);
		
	       //delete an object
      if(s != null) {
   	   session.delete(s);
   	   System.out.println("deleted successfully...");
      }else {
   	   System.out.println("Record not found..");
      }
		
		session.close();
		factory.close();

	}

}
