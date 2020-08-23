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
	<h4>Thank you for shopping with us. Please find your Order summary :</h4>

	<table border="1" cellspacing="5px" cellpadding="5px">
		<tr>
			<h4>SHIPPING TO</h4>
			</hr>
		</tr>
		<tr>
			<td>Name</td>
			<td>${user.ppersonName}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${orderSummary.user.pdeliveryAddress}</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>${user.pcontactNumber}</td>
		</tr>
		<tr>
			<td>OrderDate</td>
			<td>${user.porderDate}</td>
		</tr>
		</tr>
	</table>
	<table border="1" cellspacing="5px" cellpadding="5px">
		<h4>PAYMENT DETAILS</h4>

		<tr>
			<td>Total Cost</td>
			<td>${orderSummary.totalCost}</td>
		</tr>
	</table>

	<table border="1" cellspacing="5px" cellpadding="5px">
		<h4>ITEMS IN THE KIT</h4>
		<tr>
			<th>ProductName</th>
			<th>Cost</th>
			<th>Quantity</th>
		</tr>
		<c:forEach items="${kitLists}" var="kitDetail">
			<c:if test="${kitDetail.quantity!=0}">
				<tbody>

					<td>${kitDetail.productName}</td>
					<td>${kitDetail.amount}</td>
					<td>${kitDetail.quantity}</td>

				</tbody>
			</c:if>
		</c:forEach>
	</table>


	<jsp:include page="footer.jsp" />

</body>
</html>