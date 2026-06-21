package com.hibernate_project.mappings;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyMapping {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatedb-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txc = em.getTransaction();

		txc.begin();
		// write persistence logic here
		Department d1 = new Department("HR");
		Department d2 = new Department("IT");
		Department d3 = new Department("Finance");
		ArrayList<Department> deptList = new ArrayList<Department>(Arrays.asList(d1, d2, d3));

		for (Department d : deptList) {
			em.persist(d);
		}

		Employee[] empList = { new Employee("Satyam Sharma", d1), new Employee("Rahul Chauhan", d1),
				new Employee("Sammy Paul", d3), new Employee("Soumya Sud", d3), new Employee("Satvik Sharma", d2),  new Employee("Mehak Maurya", d2)};
		
		for(Employee e : empList) {
			em.persist(e);
			
		}
		
		
		txc.commit();
		em.close();
		emf.close();
		System.out.println("dept and emp saved successfully....");
	}
}
