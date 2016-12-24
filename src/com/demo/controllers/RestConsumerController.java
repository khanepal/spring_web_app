package com.demo.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.pojo.Products;

import java.util.List;

@Controller
public class RestConsumerController {
	@RequestMapping(value="/jsonConsumeProductById/{productId}", method=RequestMethod.GET)
	public ModelAndView jsonConsumeProductById(@PathVariable("productId") String productId) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("**************** Krishna: Inside jsonConsumeProductById");
		ModelAndView mav = new ModelAndView("restSingleProduct");
		System.out.println("**************** Krishna: After ModelAndView()");
		String url = "http://localhost:8080/Spring_Web_App/jsonGetProductById/"+productId;
		System.out.println("**************** Krishna: url: " +url);
		RestTemplate template = new RestTemplate();
		String jsonStr = template.getForObject(url, String.class);
		System.out.println("**************** Krishna: jsonStr: " +jsonStr);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("**************** Krishna: After mapper ");
		Products product = mapper.readValue(jsonStr, Products.class);
		System.out.println("**************** Krishna: After product creation");
		mav.addObject("product", product);
		System.out.println("**************** Krishna: After Adding product");
		return mav;
	}
	
	@RequestMapping(value="/jsonGetAllProductsConsume", method=RequestMethod.GET)
	public ModelAndView jsonGetAllProducts() throws JsonParseException, JsonMappingException, IOException{
		ModelAndView mav = new ModelAndView("restAllProducts");
		String url = "http://localhost:8080/Spring_Web_App/jsonGetAllProducts";
		
		RestTemplate template = new RestTemplate();
		String jsonArrayStr = template.getForObject(url, String.class);
		System.out.println("jsonArrayStr = " +jsonArrayStr);
		ObjectMapper mapper = new ObjectMapper();
		List<Products> allProducts = mapper.readValue(jsonArrayStr, TypeFactory.collectionType(List.class, Products.class));
		System.out.println("size of allProducs: " +allProducts.size());
		mav.addObject("allProducts", allProducts);
		return mav;
	}
}
