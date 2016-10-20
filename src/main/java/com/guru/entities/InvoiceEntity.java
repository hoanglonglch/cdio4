package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table (name = "invoice")
@NamedQuery(name="InvoiceEntity.findAll", query="SELECT i FROM InvoiceEntity i")
public class InvoiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	private String email;

	private String message;

	private String phone;
	
	@Column(name = "status")
	private String status;

	private String username;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="invoice")
	private List<DetailEntity> details;

	public InvoiceEntity() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<DetailEntity> getDetails() {
		return this.details;
	}

	public void setDetails(List<DetailEntity> details) {
		this.details = details;
	}

	public DetailEntity addDetail(DetailEntity detail) {
		getDetails().add(detail);
		detail.setInvoice(this);

		return detail;
	}

	public DetailEntity removeDetail(DetailEntity detail) {
		getDetails().remove(detail);
		detail.setInvoice(null);

		return detail;
	}

}