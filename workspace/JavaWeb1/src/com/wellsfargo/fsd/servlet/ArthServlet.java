package com.wellsfargo.fsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arth")
public class ArthServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		String num1 = req.getParameter("n1");
		String num2 = req.getParameter("n2");
		int result=0;
		
		switch(operation) {
		case "add":
		
		result = Integer.parseInt(num1) +Integer.parseInt(num2);			
				
		break;
		
		case "diff":	
			
			result = Integer.parseInt(num1) -Integer.parseInt(num2);				
				
			break;
			
			case "mult":
			
			result = Integer.parseInt(num1) *Integer.parseInt(num2);			
					
			break;
		case "divR":
			
			result = Integer.parseInt(num1) /Integer.parseInt(num2);			
					
			break;
			
			case "divM":	
				
				result = Integer.parseInt(num1) %Integer.parseInt(num2);				
					
				break;
			}
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<title>From servlet</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Hello <strong>"+result+"</strong></h1>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
