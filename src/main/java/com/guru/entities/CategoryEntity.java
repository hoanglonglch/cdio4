package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name = "category")
@NamedQuery(name="CategoryEntity.findAll", query="SELECT c FROM CategoryEntity c")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@NotBlank
	private String category;

	//bi-directional many-to-one association to Parent
	@ManyToOne
	private ParentEntity parent;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<ProductEntity> products;

	public CategoryEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ParentEntity getParent() {
		return this.parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity addProduct(ProductEntity product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public ProductEntity removeProduct(ProductEntity product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

}