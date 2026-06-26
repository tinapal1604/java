package com.springorm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.springorm.entities.Employee;
import jakarta.transaction.Transactional;

public class EmployeeDAO {

	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void insert(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(e);
	}
	
	public Employee getEmployee(int empId) {
		Session session = sessionFactory.openSession();
		Employee e = (Employee)session.get(Employee.class, empId);
		session.close();
		return e;
	}
	@Transactional
	public void deleteEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee e = (Employee)session.get(Employee.class, empId);
		session.remove(e);
	}
	@Transactional
	public void updateEmployee(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(e);
	}
	
	public List<Employee> getAllEmployee(){
		Session session = sessionFactory.openSession();
		List<Employee> empList = session.createQuery("from Employee", Employee.class).getResultList();
		return empList;
	}

}
