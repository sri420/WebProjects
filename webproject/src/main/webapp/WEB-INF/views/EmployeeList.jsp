<%@page import="com.sri.webproject.models.Employee"%>
<%

java.util.ArrayList<com.sri.webproject.models.Employee> empList=(java.util.ArrayList) request.getAttribute("EmployeeRecords");

if(null!=empList && empList.size()>0){
	out.println("Employee List");
	for(int i=0;i<empList.size();i++){
		Employee emp=(Employee) empList.get(i);
		out.println("Name: " + emp.getName());
		out.println("City: " + emp.getCity());
		out.println();
	}
		
}


%>