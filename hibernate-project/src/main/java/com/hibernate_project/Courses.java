package com.hibernate_project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int course_id;
	@Column
	String course_name;
	@Column(name="student_id")
	int registration_id;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(int registration_id) {
		this.registration_id = registration_id;
	}
	public Courses() {
		super();
	}
	public Courses(int course_id, String course_name, int registration_id) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.registration_id = registration_id;
	}
	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", registration_id="
				+ registration_id + "]";
	}

	
}
