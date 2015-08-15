package com.sogeti.webshop.business.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.sogeti.webshop.business.ProductService;
import com.sogeti.webshop.dao.ProductDAO;
import com.sogeti.webshop.model.Category;
import com.sogeti.webshop.model.Product;

@Stateless
public class ProductServiceImpl implements ProductService {
	
	/*@Inject
	@Named("productDAO")*/
	@Inject
	ProductDAO productDAO;;
	
	@Transactional
	public List<Category> getCategories(){
		List<Category> categories = productDAO.getCategories();
		 for(Category category:categories){
	        	
	        	if(category.getProducts() !=null){
	        	List<Product> products = 	category.getProducts();
	        	System.out.println("Category is null  >>>>"+products.size());
	        	}
	        	else
	        	{
	        		System.out.println("Category is null");
	        	}
	        	
	        }
		return categories;
	}
	
	public  List<Product> getProducts(Integer categoryId){
		List<Product> products = productDAO.getProducts(categoryId);
		return products;
	}

}
