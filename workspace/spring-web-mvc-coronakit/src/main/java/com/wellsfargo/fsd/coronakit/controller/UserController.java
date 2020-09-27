package com.wellsfargo.fsd.coronakit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.coronakit.entity.KitDetail;
import com.wellsfargo.fsd.coronakit.entity.ProductMaster;
import com.wellsfargo.fsd.coronakit.exception.CoronaException;
import com.wellsfargo.fsd.coronakit.service.CoronaKitService;
import com.wellsfargo.fsd.coronakit.service.KitDetailService;
import com.wellsfargo.fsd.coronakit.service.ProductService;



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
	
	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		return null;
	}
	

	@GetMapping("/show-list")
	public ModelAndView showList() throws CoronaException {
		return new ModelAndView("show-all-item-user","productMasters", productService.getAllProducts());
	}
	
	@PostMapping("/add-to-cart")
	public ModelAndView showKit(@ModelAttribute("ProductMaster") @Valid ProductMaster productMaster,BindingResult result, HttpSession session) throws  CoronaException {
		ModelAndView mv = null;
		ArrayList<KitDetail> cartItems ;
		int productId = (int) session.getAttribute("id");
		if(result.hasErrors()) {
			mv = new ModelAndView("show-all-item-user","productMaster",productMaster);
		//	mv.addObject("isNew",true);
		}else {
			
			//List<ProductMaster> productList = productService.getAllProducts();
		
		//	kitDetailService.addKitItem(kitItem)
			productService.addNewProduct(productMaster);
			mv = new ModelAndView("redirect:/admin/product-list","msg","product is saved successfully");
			mv.addObject("isNew",true);
			
		}
		
		return mv;
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return null;
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		return null;
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		return null;
	}
}
