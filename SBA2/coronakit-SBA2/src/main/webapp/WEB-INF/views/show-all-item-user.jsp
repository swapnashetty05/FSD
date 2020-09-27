<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show list of products</title>
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
	<jsp:include page="/header" />
	<nav class="navbar navbar-expand-md bg-light navbar-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/user/home"> Dashboard</a></li>
				<li class="nav-item"><a class="nav-link" active
					href="${pageContext.request.contextPath }/user/show-cart">Kit Details
					</a></li>
			</ul>
		</div>
	</nav></br>
 <div class="alert bg-light" style="margin:10px;">

	<nav>
		<br /> <a style="float: right; margin-right: 20px;"
			class="btn btn-sm btn btn-danger"
			href="${pageContext.request.contextPath }/user/show-cart">Go to
			Cart <svg width="1em" height="1em" viewBox="0 0 16 16"
				class="bi bi-cart" fill="currentColor"
				xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
					d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
</svg>
		</a>
	</nav>
	
	<c:choose>
		<c:when test="${productlist == null || productlist.isEmpty() }">
			<p>No Products Available to display</p>
		</c:when>
		<c:otherwise>


			<table class="table table-sm">
				<tr>
					<th>Product id</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Product Description</th>
					<th>Quantity</th>

					<th></th>
				</tr>
				<c:forEach items="${productlist}" var="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.productName }</td>
						<td>${product.cost }</td>
						<td>${product.productDescription}</td>
						<td>${Qtymap.get(product.id)}</td>

						<td><a class="btn btn-sm btn-info"
							href="${pageContext.request.contextPath }/user/add-to-cart?productId=${product.id}">Add
								to Cart <svg width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-cart" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
										d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
</svg>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</div>
	<div class="fixed-bottom bg-light"><jsp:include page="/footer" /></div>

</body>
</html>