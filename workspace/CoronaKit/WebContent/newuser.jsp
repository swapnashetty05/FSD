<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<h3>Please enter your information:</h3>

	<form action="newuser" method="post">
		<table cellspacing="5px" cellpadding="5px">

			<tr>
				<td><label>Full Name </label></td>
				<td><input type="text" name="ppersonName"
					value="${user.ppersonName}" required /></td>
			</tr>
			<tr>
				<td><label>email </label></td>
				<td><input type="text" name="pemail" value="${user.pemail}"
					required /></td>
			</tr>
			<tr>
				<td><label>contact number </label></td>
				<td><input type="text" name="pcontactNumber"
					value="${user.pcontactNumber}" required /></td>
			</tr>
		</table>
		<button>Submit</button>
	</form>
	</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
<hr/>	
	<jsp:include page="footer.jsp" />
</body>
</html>