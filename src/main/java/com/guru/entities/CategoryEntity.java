package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

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