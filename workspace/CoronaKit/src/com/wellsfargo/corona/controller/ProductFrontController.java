package com.wellsfargo.corona.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wellsfargo.corona.entity.KitDetail;
import com.wellsfargo.corona.entity.OrderSummary;
import com.wellsfargo.corona.entity.Product;
import com.wellsfargo.corona.entity.User;
import com.wellsfargo.corona.exception.ProductException;
import com.wellsfargo.corona.service.ProductService;
import com.wellsfargo.corona.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductFrontController
 */
@WebServlet({ "/adminlogin", "/notfound", "/adminlistProduct", "/admindeleteProduct", "/adminnewproduct",
		"/adminaddProduct", "/admineditProduct", "/adminsaveProduct", "/newuser", "/showproductstoadd", "/showkit",
		"/placeorder", "/ordersummary", "/logout" })
public class ProductFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	HttpSession session;
	private ProductService productService;

	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductFrontController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		request.getSession();

		String view = "";

		switch (url) {

		case "/adminlistProduct":
			view = doListProducts(request, response);
			break;
		case "/admindeleteProduct":
			view = doDeleteProduct(request, response);
			break;
		case "/adminnewproduct":
			view = doAddProduct(request, response);
			break;
		case "/adminaddProduct":
			view = doCreateorSaveProduct(request, response);
			break;
		case "/admineditProduct":
			view = doEditProduct(request, response);
			break;
		case "/adminsaveProduct":
			view = doCreateorSaveProduct(request, response);
			break;
		case "/logout":
		
			view = "index.jsp";
			break;
		case "/newuser":
			view = addUser(request, response);
			break;
		case "/showproductstoadd":
			view = showProduct(request, response);
			break;
		case "/showkit":
			view = showkit(request, response);
			break;
		case "/placeorder":
			view = placeOrder(request, response);
			break;
		case "/ordersummary":
			view = ordersummary(request, response);
			break;

		default:
			view = "notfound.jsp";
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	/*
	 * This method checks for products and returns view(String)
	 */
	private String doListProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		try {
			List<Product> products = productService.getAllProduct();
			request.setAttribute("products", products);
			view = "adminlistProduct.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String doAddProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("msg", "Product is added");

		return "adminnewproduct.jsp";
	}

	private String doEditProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		int productId = Integer.parseInt(request.getParameter("cid"));
		try {
			Product product = productService.getProduct(productId);
			request.setAttribute("product", product);
			request.setAttribute("isNew", false);
			request.getSession().setAttribute("productid", product.getPproductId());
			view = "productFormPage.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String doCreateorSaveProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product prod = new Product();
		if(request.getSession().getAttribute("productid")!=null) {
		prod.setPproductId((int) (request.getSession().getAttribute("productid")));
		}
		prod.setPproductName(request.getParameter("pproductName"));
		prod.setPdescription(request.getParameter("pdescription"));
		prod.setPcost(Float.parseFloat(request.getParameter("pcost")));
		prod.setPavailabilityStatus(request.getParameter("pavailabilityStatus"));

		String view = "";

		try {

			if (request.getServletPath().equals("/adminaddProduct")) {
				productService.validateAndAdd(prod);
			} else {
				productService.validateAndSave(prod);
			}
			request.setAttribute("msg", "Product is saved");
			view = "adminlistProduct";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String doDeleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		int ProductId = Integer.parseInt(request.getParameter("cid"));
		try {
			productService.deleteProduct(ProductId);
			request.setAttribute("msg", "Product is Deleted!");
			view = "adminlistProduct";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "index.jsp";
	}

	private String addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("kitLists", null);
		request.getSession().setAttribute("products", null);
		return "newuser.jsp";
	}

	private String showProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		User user = new User();

		try {
			user.setPpid(1);
			user.setPpersonName(request.getParameter("ppersonName"));
			user.setPemail(request.getParameter("pemail"));
			user.setPcontactNumber(request.getParameter("pcontactNumber"));
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", user);
			List<Product> products = productService.getAllProduct();
			request.setAttribute("products", products);
			view = "showproductstoadd.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String showkit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		int productId = Integer.parseInt(request.getParameter("pproductId"));

		try {
			List<Product> products;

			if (request.getSession().getAttribute("products") != null)
				products = (List<Product>) request.getSession().getAttribute("products");
			else
				products = productService.getAllProduct();

			List<KitDetail> kitList = (List<KitDetail>) request.getSession().getAttribute("kitLists");
			KitDetail kitDetail = new KitDetail();
			boolean alreadyThere = false;
			for (Product prod : products) {
				if (prod.getPproductId() == productId) {
					prod.setQuantity(Integer.parseInt(request.getParameter("quantity")));

					break;
				}

			}

			if (kitList != null) {
				for (KitDetail kitd : kitList) {
					if (kitd.getProductId() == productId) {
						kitDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));

						alreadyThere = true;
						break;
					}

				}
				if (!alreadyThere) {
					kitDetail.setProductId(productId);
					kitDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
					kitDetail.setAmount(Double.parseDouble(request.getParameter("pcost")));
					kitDetail.setProductName(findUsingIterator(kitDetail.getProductId(), products).getPproductName());
					kitList.add(kitDetail);
				}
			} else {
				kitList = new ArrayList<>();
				kitDetail.setProductId(productId);
				kitDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				kitDetail.setAmount(Double.parseDouble(request.getParameter("pcost")));
				kitDetail.setProductName(findUsingIterator(kitDetail.getProductId(), products).getPproductName());
			
				kitList.add(kitDetail);
			}
			request.getSession().setAttribute("products", products);
			request.getSession().removeAttribute("kitLists");
			request.getSession().setAttribute("kitLists", kitList);

			view = "showproductstoadd.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String placeOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "placeorder.jsp";
	}

	private String ordersummary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		OrderSummary orderSummary = new OrderSummary();
		User user = (User) request.getSession().getAttribute("user");
		user.setPdeliveryAddress((String) request.getParameter("pdeliveryAddress"));
		user.setPorderDate(LocalDate.now());
		request.getSession().setAttribute("user", user);
		orderSummary.setUser(user);

	
		orderSummary.setKitDetails((List<KitDetail>) request.getSession().getAttribute("kitLists"));
		KitDetail kitDetail = new KitDetail();
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");

		double totalCost = 0;
		if (orderSummary.getKitDetails() != null) {
			for (KitDetail kitd : orderSummary.getKitDetails()) {
				totalCost = totalCost
						+ findUsingIterator(kitd.getProductId(), products).getPcost() * kitd.getQuantity();
			}

			orderSummary.setTotalCost(totalCost);

		}
		request.getSession().setAttribute("orderSummary", orderSummary);
		return "ordersummary.jsp";
	}

	public Product findUsingIterator(int pId, List<Product> products) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getPproductId() == pId) {
				return product;
			}
		}
		return null;
	}
}
