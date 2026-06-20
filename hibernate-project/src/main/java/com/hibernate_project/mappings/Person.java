package com.hibernate_project.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int person_id;
	@Column
	private String name;
	@OneToOne
	@JoinColumn(name="passport_id", unique = true)
	private Passport passport;
	
	public Person() {
		super();
	}
	
	public Person(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	public Person(int person_id, String name, Passport passport) {
		super();
		this.person_id = person_id;
		this.name = name;
		this.passport = passport;
	}
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", name=" + name + ", passport=" + passport + "]";
	}

}
