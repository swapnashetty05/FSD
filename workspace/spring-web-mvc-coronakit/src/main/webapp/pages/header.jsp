<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">SPS Coronakit</a>
	<!-- Toggler/collapsibe Button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Navbar links -->
	<c:choose>
				<c:when test="${unm!=null && role=='ADMIN'}">

					<a href="/admin/product-list">Products List</a>
					<span>|</span>
					<a href="/admin/product-entry">Add Product</a>
					<span>|</span>
					<a href="/logout">Log Out</a>
				</c:when>
				<c:when test="${unm!=null && role=='USER'}">
					<a href="/user/show-list">Products List</a>
					<span>|</span>
					<a href="/user/show-kit">Kit Detail</a>
					<span>|</span>
					<a href="/logout">Log Out</a>
				</c:when>
				<c:otherwise>
					<a href="/login">Log In</a>
					<span>|</span>
					<a href="/register">Sign Up</a>
				</c:otherwise>
			</c:choose>
</nav>