package com.eval.coronakit.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.entity.ShippingAddress;
import com.eval.coronakit.exception.ProductException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	ProductService productService;

	@Autowired
	CoronaKitService coronaKitService;

	@Autowired
	KitDetailService kitDetailService;

	@RequestMapping("/home")
	public String home() {

		return "user-home";
	}

	@RequestMapping("/show-cart")
	public String showKit(HttpSession session, Model model) {

		List<ProductMaster> productAddedToCarts = null;
		Map<Integer, Integer> quantityMap = new HashMap<Integer, Integer>();

		List<ProductMaster> Addedproductstocart = (List<ProductMaster>) session.getAttribute("productAddedToCart");
		if (Addedproductstocart != null) {
			productAddedToCarts = new ArrayList<ProductMaster>();
			session.setAttribute("TotalQuantity", null);

			for (ProductMaster prod : Addedproductstocart) {
				if (quantityMap.containsKey(prod.getId())) {
					quantityMap.put(prod.getId(), quantityMap.get(prod.getId()) + 1);
				} else {
					quantityMap.put(prod.getId(), 1);
					productAddedToCarts.add(prod);
				}
			}
			session.setAttribute("TotalQuantity", quantityMap);
			session.setAttribute("productAddedToCart", productAddedToCarts);
		}

		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(Model model, HttpSession session) {
		model.addAttribute("productlist", productService.getAllProducts());
		session.removeAttribute("productAddedToCart");
		session.removeAttribute("TotalQuantity");
		return "show-all-item-user";
	}

	@RequestMapping("/add-to-cart")
	public String showKit(@RequestParam("productId") int productId, HttpSession session, Model model) {
		ProductMaster prod;
		List<ProductMaster> Addedproducts;
		Map<Integer, Integer> quantityMap = (Map<Integer, Integer>) session.getAttribute("TotalQuantity");
		if (quantityMap == null)
			quantityMap = new HashMap<Integer, Integer>();
		prod = productService.getProductById(productId);
		Addedproducts = (List<ProductMaster>) session.getAttribute("productAddedToCart");
		if (Addedproducts == null) {
			Addedproducts = new ArrayList<ProductMaster>();
			Addedproducts.add(prod);
		} else {
			Addedproducts.add(prod);
		}
		session.setAttribute("productAddedToCart", Addedproducts);
		if (quantityMap.containsKey(prod.getId())) {
			quantityMap.put(prod.getId(), quantityMap.get(prod.getId()) + 1);
		} else {
			quantityMap.put(prod.getId(), 1);

		}
		session.setAttribute("TotalQuantity", quantityMap);

		model.addAttribute("productlist", productService.getAllProducts());
		return "show-all-item-user";
	}

	@RequestMapping("/checkout")
	public String Checkout(HttpSession session, Model model) throws ProductException {
		model.addAttribute("ShippingAddress", new ShippingAddress());
		return "checkout-address";

	}

	@PostMapping("/finalize")
	public String finalizeOrder(@ModelAttribute("ShippingAddress") @Valid ShippingAddress shippingAddress,
			BindingResult rs, Model model, HttpSession session) throws ProductException {
		String view = null;
		if (!rs.hasErrors()) {
			KitDetail kitD;
			int Totalamount = 0;
			List<ProductMaster> Addedproductstocart = (List<ProductMaster>) session.getAttribute("productAddedToCart");
			Map<Integer, Integer> quantityMap = (Map<Integer, Integer>) session.getAttribute("TotalQuantity");
			for (ProductMaster prod : Addedproductstocart) {
				Totalamount = Totalamount + (quantityMap.get(prod.getId()) * prod.getCost());
			}

			model.addAttribute("Address", shippingAddress.getAddress());

			CoronaKit kit = new CoronaKit();

			kit.setDeliveryAddress(shippingAddress);
			kit.setOrderDate(LocalDate.now());
			kit.setTotalAmount(Totalamount);
			coronaKitService.saveKit(kit);
			
			for (ProductMaster productT : Addedproductstocart) {

				kitD = new KitDetail(kit.getId(), productT.getId(), productT.getProductName(),
						quantityMap.get(productT.getId()), (quantityMap.get(productT.getId()) * productT.getCost()));
				kitDetailService.addKitItem(kitD);
			}
			List<KitDetail> details = kitDetailService.getAllKitItemsOfAKit(kit.getId());
			model.addAttribute("kitdetails", details);
			session.setAttribute("Totalamount", Totalamount);
			session.setAttribute("OrderID", kit.getId());
			view = "show-summary";
		} else {
			view = "checkout-address";
		}
		return view;
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("productId") int productId, HttpSession session, Model model) {
		List<ProductMaster> Addedproductstocart = (List<ProductMaster>) session.getAttribute("productAddedToCart");
		List<ProductMaster> finalProductAdded = new ArrayList<ProductMaster>();
		Map<Integer, Integer> quantityMap = (Map<Integer, Integer>) session.getAttribute("TotalQuantity");

		for (ProductMaster prod : Addedproductstocart) {
			if (prod.getId() == productId) {
				quantityMap.remove(productId);
			} else {
				finalProductAdded.add(prod);
			}
		}
		session.setAttribute("TotalQuantity", quantityMap);
		session.setAttribute("productAddedToCart", finalProductAdded);

		return "show-cart";
	}
}
