package com.hibernate_project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	private int student_id;
	private String name;
	
	@Column(name="program_name")
	private String course_name;
	
	@ManyToMany
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	
	private List<Courses> subjectsOpted;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String course_name) {
	    this.student_id = id;
	    this.name = name;
	    this.course_name = course_name;
	}

	public Student(int id, String name, String course_name, List<Courses> subjectsOpted) {
		super();
		this.student_id = id;
		this.name = name;
		this.course_name = course_name;
		this.subjectsOpted = subjectsOpted;
	}
	
	public List<Courses> getSubjectsOpted() {
		return subjectsOpted;
	}

	public void setSubjectsOpted(List<Courses> subjectsOpted) {
		this.subjectsOpted = subjectsOpted;
	}

	public int getId() {
		return student_id;
	}

	public void setId(int id) {
		this.student_id = id;
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
		return "Student [id=" + student_id + ", name=" + name + ", course_name=" + course_name + ", subjectsOpted="
				+ subjectsOpted + "]";
	}


}
