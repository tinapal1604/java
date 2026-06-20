package com.hibernate_project;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	
	@Column
	private String course_name;
	
	@ManyToMany(mappedBy="subjectsOpted")
	private List<Student> students;
	
	
	public Courses() {
		super();
	}
		
	public Courses(int course_id, String course_name, List<Student> student) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.students = student;
	}
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
	public List<Student> getStudent() {
		return students;
	}
	public void setStudent(List<Student> student) {
		this.students = student;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", student=" + students + "]";
	}
	
}
