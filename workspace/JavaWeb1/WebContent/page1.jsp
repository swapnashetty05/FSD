<%@ page import="java.time.LocalDateTime" %>
<html>
<head>
<title>Java Web One</title>
</head>
<body>
<%! LocalDateTime dt = LocalDateTime.now(); %>
<h3><%=dt %> </h3>
	<h1>My First JSP </h1>
	
	
	<p>
	<%for(int i=1;i<=100;i++){%>
		 <span>swap<sup> <%=i%></sup> </span> 
	<%}%>
	</p>
	</body>
</html>