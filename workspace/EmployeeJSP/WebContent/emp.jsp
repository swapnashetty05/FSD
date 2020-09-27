<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ page import="com.wellsfargo.fsd.Model.Employee" %>  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Page</title>
</head>
<body>
<jsp:include page="banner.jsp" />
	<form action="es">

		<label>Full Name: <input type="text" name="fullName" required /></label>
		<br /> <label>basic: <input type="number" name="basic"
			required /></label> <br /> <label>hire date: <input type="date"
			name="hireDate" required /></label> <br />

		<Button>SEND</Button>
	</form>
	<c:if test="${model != null }">
		<table>
			<tr>
				<td>Full name</td>
				<td>${model.getFullName()}</td>
			</tr>
			<tr>
				<td>Basic</td>
				<td><strong>${model.getBasic() }</strong></td>
			</tr>
			<tr>
				<td>Hire Date</td>
				<td><strong>${model.getHireDate() }</strong></td>
			</tr>
			<tr>
				<td>TA</td>
				<td><strong>${model.getTa() }</strong></td>
			</tr>
			<tr>
				<td>HRA</td>
				<td><strong>${model.getHra() }</strong></td>
			</tr>


		</table>


	</c:if>
	<%-- 
	<% Employee emp = (Employee)request.getAttribute("model"); %>
	
	<% if(emp!= null) { %>
	<table>
		<tr><td>Full name </td><td>${model.getFullName()%></td></tr>
		<tr><td>Basic </td><td><strong><%=emp.getBasic() %></strong></td></tr>
		<tr><td>Hire Date </td><td><strong><%=emp.getHireDate() %></strong></td></tr>
		<tr><td>TA </td><td><strong><%=emp.getTa() %></strong></td></tr>
		<tr><td>HRA </td><td><strong><%=emp.getHra() %></strong></td></tr>
		
	
	</table>
	<%}%>
	--%>
</body>
</html>