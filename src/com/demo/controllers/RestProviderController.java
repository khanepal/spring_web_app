package com.demo.controllers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.registry.RegistryDAO;
import com.demo.pojo.Products;
import com.demo.pojo.ProductsList;

@RestController
public class RestProviderController {
	
	@RequestMapping(value="/jsonGetProductById/{productId}", method=RequestMethod.GET)
	public String jsonGetProductById(@PathVariable("productId") String productId){
		
		Products product = RegistryDAO.getProductsDAO().getProductByProductId(productId);
		product.setImage("http://localhost:8080/Spring_Web_App/img/"+product.getImage());
		JSONObject json = new JSONObject(product);
		
		return json.toString();
	}
	
	@RequestMapping(value="/jsonGetAllProducts", method=RequestMethod.GET)
	public String jsonGetAllProducts(){
		List<Products> products = RegistryDAO.getProductsDAO().getAllProducts();
		
		JSONArray jArray = new JSONArray();
		for(Products product: products){
			product.setImage("http://localhost:8080/Spring_Web_App/img/"+product.getImage());
			JSONObject json = new JSONObject(product);
			jArray.put(json);
		}
		
		return jArray.toString();
	}
	
	@RequestMapping(value="/xmlGetAllProducts", method=RequestMethod.GET)
	public ProductsList xmlGetAllProducts(){
		ProductsList productsList = new ProductsList();
		productsList.setProducts(RegistryDAO.getProductsDAO().getAllProducts());
		
		for(Products product: productsList.getProducts()){
			product.setImage("http://localhost:8080/Spring_Web_App/img/"+product.getImage());			
		}
		
		return productsList;
	}

}
