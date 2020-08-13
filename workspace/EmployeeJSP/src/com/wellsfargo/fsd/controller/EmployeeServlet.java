package com.wellsfargo.fsd.controller;


import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.Model.Employee;
import com.wellsfargo.fsd.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/es")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp = new Employee();
	
		emp.setFullName(request.getParameter("fullName"));
		
		emp.setHireDate(LocalDate.parse(request.getParameter("hireDate")));
		emp.setBasic(Double.parseDouble(request.getParameter("basic")));
		emp.setHireDate(LocalDate.parse(request.getParameter("hireDate")));
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.computeAll(emp);
		
		
		request.setAttribute("model", emp);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("emp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
