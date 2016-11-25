package com.guru.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the details database table.
 * 
 */
@Entity
@Table (name="invoicedetail")
@NamedQuery(name="InvoiceDetailEntity.findAll", query="SELECT d FROM InvoiceDetailEntity d")
public class InvoiceDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id= UUID.randomUUID().toString();
	
	private double amount;

	private int quantity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private InvoiceEntity invoice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private ProductEntity product;

	public InvoiceDetailEntity() {
	}
	
	public InvoiceDetailEntity(double amount, int quantity, InvoiceEntity invoice, ProductEntity product) {
		super();
		this.amount = amount;
		this.quantity = quantity;
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

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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