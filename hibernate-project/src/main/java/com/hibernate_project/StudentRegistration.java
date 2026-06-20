package com.hibernate_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentRegistration {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction txc = session.beginTransaction();
		//fetch student
		Student s1 = session.get(Student.class, 1004);
		Student s2 = session.get(Student.class, 1005);
		Student s3 = session.get(Student.class, 1006);
		
		List<Student> studentList = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
			
		//fetch courses
		Courses c1 = session.get(Courses.class, 1);
		Courses c2 = session.get(Courses.class, 2);
		Courses c3 = session.get(Courses.class, 3);
		Courses c4 = session.get(Courses.class, 4);
		
		ArrayList<Courses> courseList = new ArrayList<Courses>(Arrays.asList(c1, c2, c3, c4));
		
		//assign each student with the course list
		for(Student s : studentList) {
			ArrayList<Courses> studentCourses = new ArrayList<Courses>();
			for(Courses original: courseList) {
				Courses copy = new Courses();
				copy.setCourse_id(original.getCourse_id());
				copy.setCourse_name(original.getCourse_name());
				copy.setStudent(original.getStudent());
				studentCourses.add(copy);
			}
			s.setSubjectsOpted(studentCourses);
		}
			
		txc.commit();
		session.close();
		factory.close();
	}

}
