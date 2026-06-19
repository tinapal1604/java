package com.hibernate_project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="student_registration")
public class Student {
	@Id
	private int id;
	private String name;
	private String course_name;
	
	public Student(int id, String name, String course_name) {
		super();
		this.id = id;
		this.name = name;
		this.course_name = course_name;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course_name=" + course_name + "]";
	}

}
