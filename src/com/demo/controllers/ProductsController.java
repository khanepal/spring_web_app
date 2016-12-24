package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.registry.RegistryDAO;
import com.demo.models.ProductsModel;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@RequestMapping(name="/products", method=RequestMethod.GET)
	public ModelAndView loadProducts(){
		ModelAndView mav = new ModelAndView("products"); //Commented out to try below line which uses SQL instead of HQL
		//ModelAndView mav = new ModelAndView("products_1");
		ProductsModel pm = new ProductsModel();
		//mav.addObject("allProducts", pm.getAllProducts()); //This line is used when using POJO (using HQL). Replaced by the below line which uses SQL.
		//mav.addObject("allProducts", pm.getAllProductsSQL()); //Again replaced this line with below line (as a part of another learning) as we use RegistryDAO (improving architecture).
		mav.addObject("allProducts", RegistryDAO.getProductsDAO().getAllProducts());
		
		return mav;
	}

}
