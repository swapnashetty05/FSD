<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="css/site.css" />
	</head>
	<body>
		<jsp:include page="/header" />
		<form action="greet">
		<label>Name: </label>
		<input type="text" name ="userName">
		<button>OK</button>
		</form>
		<p><strong>${msg }</strong></p>
	</body>
</html>