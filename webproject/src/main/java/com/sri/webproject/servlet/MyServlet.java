package com.sri.webproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sri.webproject.models.Employee;
import com.sri.webproject.services.EmployeeService;

public class MyServlet extends HttpServlet{
	
	
	

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		System.out.println("MyServlet:doGet ...Entering");
		
		Integer empno;
		EmployeeService employeeService=new EmployeeService();
		String strAction=(String) request.getParameter("strAction");
		
		if(null!=strAction && strAction.trim().length()>0) {
			if("ADD".equalsIgnoreCase(strAction)) {
				
				RequestDispatcher requestDispatcher =
					    request.getRequestDispatcher("/WEB-INF/views/NewEmployee.jsp");
				requestDispatcher.include(request, response);
				
			}else if("showall".equalsIgnoreCase(strAction)) {
				
				System.out.println("MyServlet:doGet ...Fetching All Employee Records");
				List<Employee> eList=employeeService.getEmployeeRecords();
				request.setAttribute("EmployeeRecords", eList);

				 RequestDispatcher requestDispatcher =
						    request.getRequestDispatcher("/WEB-INF/views/EmployeeList.jsp");
				 requestDispatcher.include(request, response);
				 
			}else if("SearchByEmpno".equalsIgnoreCase(strAction)) {
				
				String strEmpno=(String) request.getParameter("empno");
				
				if(null!=strEmpno && strEmpno.trim().length()>0) {
					empno=(Integer.parseInt(strEmpno));
					System.out.println("MyServlet:doGet ...Fetching by passed empno:"+empno);
					Employee employee=employeeService.viewEmployeeDetails(empno);
					request.setAttribute("selectedEmployee", employee);

					 RequestDispatcher requestDispatcher =
							    request.getRequestDispatcher("/WEB-INF/views/Employee.jsp");
					 requestDispatcher.include(request, response);
				}
			}
		}
		
		System.out.println("MyServlet:doGet ...Leaving");
		
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyServlet:doPost ...Entering");
		
		Employee employee=new Employee();
		
		String empno=request.getParameter("empno");
		String empname=request.getParameter("empname");
		String empcity=request.getParameter("empcity");
		String empage=request.getParameter("empage");
		
		
		if(null!=empno && empno.trim().length()>0) {
			employee.setId(Integer.parseInt(empno));
		}else {
			System.out.println("MyServlet:doPost ...Invalid Empno");
		}
		if(null!=empname && empname.trim().length()>0) {
			employee.setName(empname);
		}else {
			System.out.println("MyServlet:doPost ...Invalid EmpName");
		}
		if(null!=empcity && empcity.trim().length()>0) {
			employee.setCity(empcity);
		}else {
			System.out.println("MyServlet:doPost ...Invalid empcity");
		}
		if(null!=empage && empage.trim().length()>0) {
			employee.setAge(Integer.parseInt(empage));
		}else {
			System.out.println("MyServlet:doPost ...Invalid empage");
		}
		
		
		EmployeeService employeeService=new EmployeeService();
		if(employeeService.addEmployee(employee)>0) {
			System.out.println("MyServlet:doPost ...Employee Record Added Successfully");
		}
		
		System.out.println("MyServlet:doGet ...Fetching All Employee Records");
		
		List<Employee> eList=employeeService.getEmployeeRecords();
		request.setAttribute("EmployeeRecords", eList);

		 RequestDispatcher requestDispatcher =
				    request.getRequestDispatcher("/WEB-INF/views/EmployeeList.jsp");
		 requestDispatcher.include(request, response);
		 
		
		
		System.out.println("MyServlet:doPost ...Leaving");
	}
}
