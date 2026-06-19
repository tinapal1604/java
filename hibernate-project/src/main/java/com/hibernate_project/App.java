package com.hibernate_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       SessionFactory factory = new Configuration()
    		   .configure("hibernate.cfg.xml")
    		   .buildSessionFactory();
       System.out.println(factory);
       
       //create student
       Student[] studentList = {
    		   new Student(1004, "Mike", "B.Tech"),
    		   new Student(1005, "Camella", "B.Tech"),
    		   new Student(1006, "Juilet", "B.Tech"),
       };
       
       Session session = factory.openSession();
       Transaction txc = session.beginTransaction();
       
       //save all student
       for(Student s: studentList) {
           session.save(s);
         
       }
       Courses[] courseList = {
    		   new Courses(1, "Engineering Mathematics", null),
    		   new Courses(2, "Physics", null),
    		   new Courses(3, "Chemistry", null),
    		   new Courses(4, "Introduction to programming in C", null)
       };
       //save all courses
       for(Courses c: courseList) {
    	   session.save(c);
       }
             
       txc.commit();
       session.close();
       factory.close();
    }
}
