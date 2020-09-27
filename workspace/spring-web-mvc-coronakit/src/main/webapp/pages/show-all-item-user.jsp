<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPS Corona Kit Application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/header" />

	<section class="container-fluid p-4">
		<section class="container-fluid p-4">

			<c:if test="${isNew}">
				<div class="card card-info">

					<div class="card-body">
						<p>product is saved successfully</p>
					</div>
				</div>
			</c:if>
		</section>
		<c:choose>
			<c:when
				test="${productMasters == null || productMasters.isEmpty() && !(isNew)}">
				<p class="well well-danger">No products Available</p>
			</c:when>
			<c:otherwise>
			<form:form method="post" action="/user/add-to-cart" modelAttribute="productMasters">
				<table class="table table-striped table-hover">
					<tr>

						<th>productName</th>
						<th>cost</th>
						<th>productDescription</th>
						<th>Quantity</th>

					</tr>
					<c:forEach items="${productMasters }" var="product">
						<tr>

							<td>${product.productName }</td>
							<td>${product.cost }</td>
							<td>${product.productDescription }</td>
							<input type="hidden" name="id" value="${product.id}" />
							<input type="hidden" name="cost" value="${product.cost}" />

							<td><input type="number" name="quantity"
								value="${product.quantity}" /> </td>
								
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="ADD" />
	
</form:form>
			</c:otherwise>
		</c:choose>

	</section>
</body>
</html>