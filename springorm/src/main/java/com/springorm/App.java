package com.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.EmployeeDAO;
import com.springorm.entities.Employee;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDAO empDao = context.getBean("empDao", EmployeeDAO.class);

		Employee[] empList = { new Employee(105, "Meena"), new Employee(101, "Rita"), new Employee(102, "Geeta"),
				new Employee(103, "Mita"), new Employee(104, "Pushpa"),

		};

		for (Employee e : empList) {
			empDao.insert(e);
		}

		System.out.println("saved successfully...");

		System.out.println(empDao.getEmployee(104));
		empDao.deleteEmployee(100);
		// update employee

		empDao.updateEmployee(new Employee(104, "Reshma"));
		List<Employee> empList2 = empDao.getAllEmployee();
		for (Employee e : empList2) {
			System.out.println(e);
		}

	}
}
