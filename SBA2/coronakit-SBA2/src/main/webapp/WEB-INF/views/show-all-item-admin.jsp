<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
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
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

 <div class="collapse navbar-collapse" id="collapsibleNavbar">
	<ul class="navbar-nav">
	
 		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/admin/home">ADMIN DASHBOARD</a>
	      </li> 
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/admin/product-entry">Add Product</a>
	      </li>
		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/admin/product-list">Products List</a>
	      </li>
	 </ul> 
</div>
</nav> <div class="alert bg-light" style="margin:10px;">
<p class="font-weight-bold text-info" style="float:center;"><h5>Below are the products available in Corona-Kit</h5></p>
<c:if test="${deleteconfirmationmsg!=null}">
	<p class="well"> Product is Deleted.</p>
	<br/>
	</c:if>
	 <c:choose>  
        <c:when test="${productlist == null || productlist.isEmpty() }">  
            <p class="well">No Products Available to display</p>  
        </c:when>  
        <c:otherwise>  </br>
            <table class="table table-sm">  
                <tr>  
                   <!--  <th>Product id</th>   -->
                    <th>Product Name</th>  
                    <th>Product Cost</th>  
                    <th>Product Description</th>   
                    <th></th>                    
                </tr>  
                <c:forEach items="${productlist}" var="product">  
                    <tr>  
                         <!-- <td>${product.id }</td>   -->
                        <td>${product.productName }</td>  
                        <td>${product.cost }</td>  
                        <td>${product.productDescription}</td>                        
                        <td>
                        <a href="${pageContext.request.contextPath }/admin/product-delete?productId=${product.id}"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
</svg></a>                       
                        </td>
                    </tr>  
                </c:forEach>  
            </table>  
        </c:otherwise>  
    </c:choose>
    </div>
<jsp:include page="/footer" />
</body>
</html>