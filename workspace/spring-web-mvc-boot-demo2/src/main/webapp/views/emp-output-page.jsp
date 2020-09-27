<html>
<head>
<title>Employee Output Page</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<jsp:include page="/header" />
	<section>
		<h3>Employee Details</h3>

		<table>
			<tr>
				<td><strong>EmpID</strong></td>
				<td>${emp.empID}</td>
			</tr>
			<tr>
				<td><strong>name</strong></td>
				<td>${emp.name}</td>
			</tr>
			<tr>
				<td><strong>designation</strong></td>
				<td>${emp.designation}</td>
			</tr>
			<tr>
				<td><strong>basic</strong></td>
				<td>${emp.basic}</td>
			</tr>
			<tr>
				<td><strong>ta</strong></td>
				<td>${emp.ta}</td>
			</tr>
			<tr>
				<td><strong>hra</strong></td>
				<td>${emp.hra}</td>
			</tr>
		</table>
	</section>
</body>
</html>