package com.wellsfargo.fsd.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.Model.Loan;
import com.wellsfargo.fsd.service.LoanService;

/**
 * Servlet implementation class LoanServlet
 */
@WebServlet("/ls")
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Loan loan = new Loan();
		
		

		
		loan.setEmiCount(Integer.parseInt(request.getParameter("emiCount")));
		loan.setPrinciple(Integer.parseInt(request.getParameter("principle")));
		loan.setRateOfInterest(Integer.parseInt(request.getParameter("rateOfInterest")));
		
		LoanService loanService = new LoanService();
		loanService.computeEmi(loan);
		request.setAttribute("loanModel", loan);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("emi.jsp");
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
