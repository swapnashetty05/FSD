<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New product</title>
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
					href="${pageContext.request.contextPath }/admin/home">ADMIN
						DASHBOARD</a></li>
						<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/admin/product-entry">Add
						Product</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/admin/product-list">Products
						List</a></li>
			</ul>
		</div>
	</nav>
	 <div class="alert bg-light" style="margin:10px;">
	<p class="font-weight-bold text-info" style="float:center;"><h5>Add a new Product</h5></p>

		<div class="col-sm-4">
			<form:form
				action="${pageContext.request.contextPath }/admin/product-save"
				method="post" modelAttribute="product">

				<br />
				<div class="form-group">
					<form:label path="productName" >Product Name</form:label>
					<form:input type="text" path="productName" class="form-control" />
					<form:errors path="productName" class="alert alert-warning" />
				</div>
				<br />
				<div class="form-group">
					<form:label path="cost">Product Cost</form:label>
					<form:input type="number" min="0" path="cost" class="form-control" />
					<form:errors path="cost" class="alert alert-warning" />
				</div>
				<br />
				<div class="form-group">
					<form:label path="productDescription">Product Description</form:label>
					<form:textarea type="text" path="productDescription"
						class="form-control" />
					<form:errors path="productDescription" class="alert alert-warning" />
				</div>
				<br />
				<div class="form-group">
					<button class="btn pull-right btn-info">Add Product</button>
				</div>
				<br />
			</form:form>
		</div>


<jsp:include page="/footer" />
</body>
</html>