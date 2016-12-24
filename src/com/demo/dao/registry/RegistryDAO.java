package com.demo.dao.registry;

import com.demo.dao.implementation.ProductsDAO;

public class RegistryDAO {
	
	public static com.demo.dao.layer.ProductsDAO productsDAO;
	
	static{
		productsDAO = new ProductsDAO();
	}

	public static com.demo.dao.layer.ProductsDAO getProductsDAO() {
		return productsDAO;
	}

	public static void setProductsDAO(com.demo.dao.layer.ProductsDAO productsDAO) {
		RegistryDAO.productsDAO = productsDAO;
	}	

}
