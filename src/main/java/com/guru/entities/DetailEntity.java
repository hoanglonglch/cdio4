package com.guru.entities;

import java.io.Serializable;
import java.util.UUID;

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
	private String id= UUID.randomUUID().toString();
	
	private double amount;

	private int quanlity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private InvoiceEntity invoice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private ProductEntity product;

	public DetailEntity() {
	}
	
	public DetailEntity(double amount, int quanlity, InvoiceEntity invoice, ProductEntity product) {
		super();
		this.amount = amount;
		this.quanlity = quanlity;
		this.invoice = invoice;
		this.product = product;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuanlity() {
		return this.quanlity;
	}

	public void setQuanlity(int quanlity) {
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