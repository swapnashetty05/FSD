<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPS Corona Kit Online Store</title>
<h1>SPS Corona Kit Online Store</h1>
<p>Best Online shopping store for COVID-19 products.</p>
<hr />
</head>
<body>


	<c:if test="${msg != null }">
		<p>
			<strong>${msg }</strong>
		</p>
	</c:if>
	<h2>Please login If you are Admin</h2>
	<form action="adminlistProduct" method="post">
		<div>
			<div>
				<label for="loginid">Enter login Id</label>
			</div>
			<div>
				<input type="text" id="loginid" name="loginid">
			</div>
		</div>
		</br>
		<div>
			<div>
				<label for="password">Enter password</label>
			</div>
			<div>
				<input type="password" id="password" name="password">
			</div>
		</div>
		</br>
		<div>
			<div>
				<input type="submit" value="Login">
			</div>
		</div>
	</form>
	</div>

	</br>
	</br>
	<div>
		<h2>
			Are you a new user who wants to order corona kit from us? Please
			click here <a href="newuser"><button>Create Corona Kit</button></a>
		</h2>

	</div>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>