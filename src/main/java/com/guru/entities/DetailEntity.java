package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the details database table.
 * 
 */
@Entity
@Table (name="details")
@NamedQuery(name="DetailEntity.findAll", query="SELECT d FROM DetailEntity d")
public class DetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String amount;

	private String quanlity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private InvoiceEntity invoice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private ProductEntity product;

	public DetailEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getQuanlity() {
		return this.quanlity;
	}

	public void setQuanlity(String quanlity) {
		this.quanlity = quanlity;
	}

	public InvoiceEntity getInvoice() {
		return this.invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}