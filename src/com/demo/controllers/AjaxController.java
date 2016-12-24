package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.registry.RegistryDAO;

@Controller
public class AjaxController {
	
	@ResponseBody
	@RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request){
		
		String productId = request.getParameter("productId");
		
		boolean flag = RegistryDAO.getProductsDAO().deleteProductById(productId);
		
		if(flag){
			return "Product deleted successfully";
		}
		else{
			return "Please try again later";
		}
	}

}
