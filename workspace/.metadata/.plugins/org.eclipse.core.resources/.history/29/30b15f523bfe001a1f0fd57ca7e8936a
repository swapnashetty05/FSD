<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">LMS</a>
	<!-- Toggler/collapsibe Button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/home">Home</a></li>

			<c:choose>
				<c:when test="${unm!=null && role=='ADMIN'}">

					<a href="${pageContext.request.contextPath}/admin/list">Items
						List</a>
					<span>|</span>
					<a href="${pageContext.request.contextPath}/admin/newLoan">Add
						New</a>
					<span>|</span>
					<a href="${pageContext.request.contextPath}/logout">Log Out</a>
				</c:when>
				<c:when test="${unm!=null && role=='USER'}">
					<a href="${pageContext.request.contextPath}/user/list">Items
						List</a>
					<span>|</span>
					<a href="${pageContext.request.contextPath}/logout">Log Out</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/login">Log In</a>
					<span>|</span>
					<a href="${pageContext.request.contextPath}/register">Sign Up</a>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>