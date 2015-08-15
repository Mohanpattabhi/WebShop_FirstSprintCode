package com.sogeti.webshop.userweb.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.sogeti.webshop.business.ProductService;
import com.sogeti.webshop.model.Category;
import com.sogeti.webshop.model.Product;

@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ProductService productService;

	private List<Product> productList;

	private List<Category> categories;

	private String value;

	public List<Product> getProductList() {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String action = params.get("action");
		String selectedCategory = params.get("selectedCategory");
		System.out.println("action >>>>" + action);
		List<Product> products = productService.getProducts(Integer.valueOf(1));
		setProductList(productList);
		this.productList = productList;
		this.value = "TESTING";
		// return productList;

		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String displayProduct() {

		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String action = params.get("action");
		String selectedCategory = params.get("selectedCategory");
		System.out.println("action >>>>" + action);
		List<Product> products = productService.getProducts(Integer
				.valueOf(selectedCategory));
		setProductList(products);
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().setAttribute("productList", products);
		request.getSession().setAttribute("selectedCategoryId",
				selectedCategory);
		request.setAttribute("value", "VALUE");
		this.productList = products;
		this.value = "TESTING";
		return "productDetails";
	}

	public void populateCategories() {
		categories = new ArrayList<Category>();

		List<Category> categoryEntities = productService.getCategories();

		setCategories(categoryEntities);

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Category> getCategories() {
		categories = new ArrayList<Category>();

		List<Category> categoryEntities = productService.getCategories();

		categories.addAll(categoryEntities);
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}