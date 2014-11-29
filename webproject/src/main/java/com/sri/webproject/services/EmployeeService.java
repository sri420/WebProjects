package com.sri.webproject.services;

import java.util.List;

import com.sri.webproject.DAO.EmployeeDAO;
import com.sri.webproject.models.Employee;

public class EmployeeService {

	
	public List<Employee> getEmployeeRecords() {
		System.out.println("EmployeeService:getEmployeeRecords() ...Entering");
		EmployeeDAO employeeDAO=new EmployeeDAO();
		System.out.println("EmployeeService:getEmployeeRecords() ...Leaving");
		return employeeDAO.getEmployeeRecords();
	}
	public Employee viewEmployeeDetails(Integer empno) {
		System.out.println("EmployeeService:viewEmployeeDetails ...Entering");
		EmployeeDAO employeeDAO=new EmployeeDAO();
		System.out.println("EmployeeService:viewEmployeeDetails ...Leaving");
		return employeeDAO.viewEmployeeDetails(empno);
	}
	public int addEmployee(Employee employee) {
		System.out.println("EmployeeService:addEmployee() ...Entering");
		EmployeeDAO employeeDAO=new EmployeeDAO();
		System.out.println("EmployeeService:addEmployee() ...Leaving");
		return employeeDAO.addEmployee(employee);
	}

}
