<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Employee Page</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<h3>Employee Form</h3>

	<form:form method="POST" modelAttribute="emp">

		<div>
			<form:label path="empID">Employee ID: </form:label>
			<form:input type="number" path="empID" />
		</div>
		<div>
			<form:label path="name">Employee name: </form:label>
			<form:input type="text" path="name"/>
		</div>
		<div>
			<form:label path="basic">Employee basic: </form:label>
				<form:input type="number" path="basic"/>
		</div>
		<div>
			<form:label path="designation">Designation</form:label>
				<form:select path="designation" items="${designations}"/>



					</select>
		</div>
		<button>SEND</button>
	</form:form>
	<!--<form method="POST">
		<div>
			<label>Employee ID: </label> <input type="number" name="empID"
				id="txt1">

		</div>
		<div>
			<label>Employee name: </label> <input type="text" name="name">

		</div>
		<div>
			<label>Employee basic: </label> <input type="number" name="basic">

		</div>
		<div>
			<label>Designation</label> <select name="designation">

				<option value="SE">Software Engineer</option>
				<option value="SSE">Sen Software Engineer</option>
				<option value="PM">Project Manager</option>
				<option value="DM">Delivery Manager</option>

			</select>
		</div>
		<button>SEND</button>
	</form> -->
	<p>
		<strong>${msg }</strong>
	</p>
</body>
</html>