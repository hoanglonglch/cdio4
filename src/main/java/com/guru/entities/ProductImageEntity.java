package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_image database table.
 * 
 */
@Entity
@Table(name="product_image")
@NamedQuery(name="ProductImageEntity.findAll", query="SELECT p FROM ProductImageEntity p")
public class ProductImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	//bi-directional many-to-one association to Image
	@ManyToOne
	private ImageEntity image;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private ProductEntity product;

	public ProductImageEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageEntity getImage() {
		return this.image;
	}

	public void setImage(ImageEntity image) {
		this.image = image;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}