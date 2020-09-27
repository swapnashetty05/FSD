package com.wellsfargo.fsd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletB
 */
@WebServlet("/servletB")
public class servletB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m1 = request.getParameter("m1");
		System.out.println("ServletB: " + m1);
		String m2 = (String)request.getAttribute("m2");
		System.out.println("ServletB: " + m2);
		String m3 = "A msg from servlet B";
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h3>Param Form Client: "+m1+"</h3>");
		out.println("<h3>Attrib Form ServletA: "+m2+"</h3>");
		out.println("<h3>Attrib Form ServletB: "+m3+"</h3>");
		out.println("<hr/> <a href='index.jsp'>Home</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
