package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table (name="images")
@NamedQuery(name="ImageEntity.findAll", query="SELECT i FROM ImageEntity i")
public class ImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@NotBlank
	private String image;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="image", fetch=FetchType.LAZY)
	private List<ProductImageEntity> productImages;

	public ImageEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ProductImageEntity> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImageEntity> productImages) {
		this.productImages = productImages;
	}

	public ProductImageEntity addProductImage(ProductImageEntity productImage) {
		getProductImages().add(productImage);
		productImage.setImage(this);

		return productImage;
	}

	public ProductImageEntity removeProductImage(ProductImageEntity productImage) {
		getProductImages().remove(productImage);
		productImage.setImage(null);

		return productImage;
	}

}