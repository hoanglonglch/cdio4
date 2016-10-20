package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table (name = "product")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String description;

	private String image;

	private String name;

	private String price;

	private String quanlity;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="product")
	private List<DetailEntity> details;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private CategoryEntity category;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="product")
	private List<ProductImageEntity> productImages;

	public ProductEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuanlity() {
		return this.quanlity;
	}

	public void setQuanlity(String quanlity) {
		this.quanlity = quanlity;
	}

	public List<DetailEntity> getDetails() {
		return this.details;
	}

	public void setDetails(List<DetailEntity> details) {
		this.details = details;
	}

	public DetailEntity addDetail(DetailEntity detail) {
		getDetails().add(detail);
		detail.setProduct(this);

		return detail;
	}

	public DetailEntity removeDetail(DetailEntity detail) {
		getDetails().remove(detail);
		detail.setProduct(null);

		return detail;
	}

	public CategoryEntity getCategory() {
		return this.category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<ProductImageEntity> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImageEntity> productImages) {
		this.productImages = productImages;
	}

	public ProductImageEntity addProductImage(ProductImageEntity productImage) {
		getProductImages().add(productImage);
		productImage.setProduct(this);

		return productImage;
	}

	public ProductImageEntity removeProductImage(ProductImageEntity productImage) {
		getProductImages().remove(productImage);
		productImage.setProduct(null);

		return productImage;
	}

}