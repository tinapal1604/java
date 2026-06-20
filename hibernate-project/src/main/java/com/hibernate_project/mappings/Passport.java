package com.hibernate_project.mappings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passport_id;
	@Column
	private String passportNumber;
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	
	public Passport() {
		super();
	}

	public Passport(String passportNumber) {
		super();
		this.passportNumber = passportNumber;
	}

	public Passport(int passport_id, String passportNumber, Person person) {
		super();
		this.passport_id = passport_id;
		this.passportNumber = passportNumber;
		this.person = person;
	}
	
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [passport_id=" + passport_id + ", passportNumber=" + passportNumber + ", person=" + person
				+ "]";
	}

	

}
