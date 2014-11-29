<%@page import="com.sri.webproject.models.Employee"%>
<%

Employee employee=(Employee) request.getAttribute("selectedEmployee");

if(null!=employee){
		out.println("Employee Details");
		out.println("Name: " + employee.getName());
		out.println("City: " + employee.getCity());
		out.println("Age: " + employee.getAge());
}


%>