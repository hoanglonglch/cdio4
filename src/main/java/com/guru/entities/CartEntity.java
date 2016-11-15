package com.guru.entities;

import java.io.Serializable;

public class CartEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductEntity productEntity;
	private int quantity;
	public CartEntity() {
		super();
	}
	
	public CartEntity(ProductEntity productEntity, int quantity) {
		super();
		this.productEntity = productEntity;
		this.quantity = quantity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
