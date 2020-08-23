package com.wellsfargo.corona.filter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter("/*")
public class AdminLoginFilter implements Filter {

	private HttpServletRequest httpRequest;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String loginURI = req.getContextPath() + "/admin";

		boolean loggedIn = session != null && session.getAttribute("admin") != null;
		boolean loginRequest = req.getRequestURI().contains(loginURI);
		String username = req.getParameter("loginid");
		String password = req.getParameter("password");
		Map<String, String> adminCred = new HashMap<String, String>();
		RequestDispatcher rd;

		if (loggedIn && loginRequest) {
			chain.doFilter(request, response);
		} else if (!checkValidUrls(req.getRequestURI())) {
			rd = request.getRequestDispatcher("notfound.jsp");
			rd.include(request, response);
		} else if (loginRequest && (username == null || password == null)) {
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		} else if (loginRequest && (username.equals("Admin") && password.equals("Admin"))) {
			adminCred.put(username, password);
			req.getSession().setAttribute("admin", adminCred);
			chain.doFilter(request, response);

		} else if (loginRequest && !(username.equals("Admin") && password.equals("Admin"))) {
			request.setAttribute("msg", "username or password error!");
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		} else if (!req.getRequestURI().contains("admin") || req.getRequestURI().contains("logout")) {
			chain.doFilter(request, response);
			req.getSession().removeAttribute("admin");
		} else {
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

	public Boolean checkValidUrls(String checkUrl) {
		String[] validUrls = { "/adminlogin", "/notfound", "/adminlistProduct", "/admindeleteProduct", "/adminnewproduct",
				"/adminaddProduct", "/admineditProduct", "/adminsaveProduct", "/newuser", "/showproductstoadd", "/showkit",
				"/placeorder", "/ordersummary", "/logout", "/index"};

		Boolean valid = false;
		if(checkUrl.equals("/CoronaKit/")) {
			return true;
		
		}
		for (String validUrl : validUrls) {
			if (checkUrl.contains(validUrl)){
				valid = true;
			}			
		}
		
		return valid;

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
