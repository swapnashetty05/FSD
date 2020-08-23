<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
<p>Please select the products and enter the quantity required</p>
	<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			<p>no products available</p>
		</c:when>

		<c:otherwise>

			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					
					<th>ProductName</th>
					<th>Description</th>
					<th>Cost</th>
					<th>AvailabilityStatus</th>
				</tr>
				<c:forEach items="${products}" var="product">


					<tbody>
						<tr>
							
							<td>${product.pproductName}</td>
							<td>${product.pdescription}</td>
							<td><label name="pcost" value="${product.pcost}">${product.pcost}</label></td>
							<td>${product.pavailabilityStatus}</td>
							<td><form action="showkit" method="post">
									<label>Quantity<input type="hidden" name="pproductId"
										value="${product.pproductId}" /> 
										<input type="hidden" name="pcost"
										value="${product.pcost}" />
										<c:choose>
										    <c:when test="${product.pavailabilityStatus.equals('AVAILABLE')}">
										       <input type="number"
																				name="quantity" min="0" value="${product.quantity}"  />
																				<c:choose>
																				<c:when test="${product.quantity==0}">
																					<button>ADD</button>
																				</c:when> 
																				<c:otherwise>
																					<button>UPDATE</button>
																				 </c:otherwise>
																				 </c:choose>
										    </c:when>    
										    <c:otherwise>
										       <input type="number"
																				name="quantity" value="${product.quantity}" disabled />
																				<button disabled>ADD</button>
										    </c:otherwise>
										</c:choose>
										
										</label>
									
								</form></td>

						</tr>
					</tbody>

				</c:forEach>

			</table>

		</c:otherwise>
	</c:choose>
<form action="placeorder" method="post">
									
									<button>Place Order</button>
								</form>

	<hr />
	<jsp:include page="footer.jsp" />
</html>