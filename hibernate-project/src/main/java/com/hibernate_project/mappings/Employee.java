package com.hibernate_project.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department dept;
	
	public Employee() {
		super();
	}

	public Employee(String name, Department dept) {
		super();
		this.name = name;
		this.dept = dept;
	}

	public Employee(int emp_id, String name, Department dept) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.dept = dept;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", dept=" + dept + "]";
	}
	
	

}
