<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="com.wellsfargo.fsd.Model.Loan" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI details</title>
</head>
<body>
<form action="ls">
		
		
		<label>EMICount: <input type="number" name="emiCount" required/></label> <br />
		<label>Principle: <input type="number" name="principle" required/></label> <br />
		<label>RateOfInterest: <input type="number" name="rateOfInterest" required/></label> <br />
		<Button>SEND</Button>
	</form>
	

<% Loan loan = (Loan)request.getAttribute("loanModel"); %>
	
	<% if(loan!= null) { %>
	<table>
		
		<tr><td>Principle </td><td><strong><%=loan.getPrinciple() %></strong></td></tr>
		<tr><td>RateOfInterest </td><td><strong><%=loan.getRateOfInterest() %></strong></td></tr>
		<tr><td>EMICount </td><td><strong><%=loan.getEmiCount() %></strong></td></tr>
		<tr><td>EMI </td><td><strong><%=loan.getEmi() %></strong></td></tr>
	
	</table>
	<%}%>
</body>
</html>