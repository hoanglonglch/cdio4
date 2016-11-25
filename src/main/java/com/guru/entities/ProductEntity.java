package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
	
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
	private String id= UUID.randomUUID().toString();

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String image;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private double price;
	
	@NotBlank
	private int quantity;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<InvoiceDetailEntity> details;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private CategoryEntity category;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY)
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<InvoiceDetailEntity> getDetails() {
		return this.details;
	}

	public void setDetails(List<InvoiceDetailEntity> details) {
		this.details = details;
	}

	public InvoiceDetailEntity addDetail(InvoiceDetailEntity detail) {
		getDetails().add(detail);
		detail.setProduct(this);

		return detail;
	}

	public InvoiceDetailEntity removeDetail(InvoiceDetailEntity detail) {
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