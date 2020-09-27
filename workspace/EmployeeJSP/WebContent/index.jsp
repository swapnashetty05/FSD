<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ page import="com.wellsfargo.fsd.Model.Employee" %>  --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<jsp:include page="banner.jsp" />

<form action="servletA">
		<label>Message
			<input type="text" name="m1" />
		</label>
		<button name="action" value="f">FORWARD</button>
		<button name="action" value="r">REDIRECT</button>
	</form>

</body>
</html>