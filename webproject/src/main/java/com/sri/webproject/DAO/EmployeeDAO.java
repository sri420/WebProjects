package com.sri.webproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sri.webproject.models.Employee;
import com.sri.webproject.utils.DBUtil;

public class EmployeeDAO {
	public int addEmployee(Employee employee) {
		System.out.println("EmployeeDAO:addEmployee()... Entering");
		Connection connection=DBUtil.getConnection();
		int count=0;
		
		try {
			PreparedStatement statement=connection.prepareStatement("Insert into employee(id,name,age,city) values(?,?,?,?)");
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getName());
			statement.setInt(3, employee.getAge());
			statement.setString(4, employee.getCity());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(null!=connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("EmployeeDAO:addEmployee()... Leaving");
		return count;
	}
	
	
	public List<Employee> getEmployeeRecords() {
		System.out.println("EmployeeDAO:getEmployeeRecords..Entering.");
		Connection connection=DBUtil.getConnection();
		ResultSet resultSet=null;
		Employee emp=null;
		List<Employee> empList=null;
		try {
			empList=new ArrayList<Employee>();
			String sql="Select * from employee";
			System.out.println("DAO: sql is: " + sql);
			PreparedStatement statement=connection.prepareStatement(sql);
			System.out.println("DAO: pstmt is: " + statement.toString());
			resultSet=statement.executeQuery(); 
			while(resultSet.next()) {
				emp=new Employee();
				emp.setId(resultSet.getInt("id"));
				emp.setName(resultSet.getString("name"));
				emp.setCity(resultSet.getString("city"));
				emp.setAge(resultSet.getInt("age"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(null!=resultSet) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null!=connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("EmployeeDAO:getEmployeeRecords..Leaving.");
		return empList;
	}
	
	public Employee viewEmployeeDetails(Integer intEempno) {
		System.out.println("EmployeeDAO:viewEmployeeDetails()..Entering.");
		Connection connection=DBUtil.getConnection();
		Employee emp=null;
		try {
			String sql="Select * from employee where id in (?)";
			System.out.println("DAO: sql is: " + sql);
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, intEempno);
			System.out.println("DAO: pstmt is: " + statement.toString());
			ResultSet resultSet=statement.executeQuery(); 
			while(resultSet.next()) {
				emp=new Employee();
				emp.setId(resultSet.getInt("id"));
				emp.setName(resultSet.getString("name"));
				emp.setCity(resultSet.getString("city"));
				emp.setAge(resultSet.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(null!=connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("EmployeeDAO:viewEmployeeDetails()..Leaving.");
		return emp;
	}

}
