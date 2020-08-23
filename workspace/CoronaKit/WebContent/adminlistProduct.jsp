<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPS Corona Kit Online Store</title>
</head>
<body>
	<jsp:include page="header.jsp" />
<c:if test="${msg != null }">
		<p>
			<strong>${msg }</strong>
		</p>
	</c:if>
	<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			<p>no products available</p>
		</c:when>

		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>Description</th>
					<th>Cost</th>
					<th>AvailabilityStatus</th>
				</tr>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.pproductId}</td>
						<td>${product.pproductName}</td>
						<td>${product.pdescription}</td>
						<td>${product.pcost}</td>
						<td>${product.pavailabilityStatus}</td>
						<td><a href="admindeleteProduct?cid=${product.pproductId}">DELETE</a>
							<span>|</span> <a href="admineditProduct?cid=${product.pproductId}">EDIT</a>

						</td>
					</tr>

					
				</c:forEach>
			</table>
			<table border="1" align="center" >
					<tr>
						<td><a href="adminnewproduct">ADD
								PRODUCT</a></td>
					</tr>
					</table>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="footer.jsp" />
</body>
</html>