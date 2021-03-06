package com.sogeti.webshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable {

	@Id
	@SequenceGenerator(name = "WEBSHOPSEQ", sequenceName = "WEBSHOPSEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WEBSHOPSEQ")
	@Column(name = "ID", nullable = false)
	private Integer productId;
	
	
	@Column(name="NAME")
	   private String name;
	
	@Column(name="DESCRIPTION")
	   private String description;
	
	@Column(name="PRICE")
	private String price;
	
	 @ManyToOne
	 @JoinColumn(name="PRODUCT_CATEGORY_ID")
	private Category category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	
	
	
	
}
