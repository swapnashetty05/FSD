package com.wellsfargo.fsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("unm");
		
		if(username == null) {
			username = "Stranger";
		}
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<title>From servlet</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Hello <strong>"+username+"</strong></h1>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	
}
