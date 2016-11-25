package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.guru.validator.Phone;

import java.util.Date;
import java.util.List;
import java.util.UUID;


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
	private String id= UUID.randomUUID().toString();

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@NotBlank
	@Email
	private String email;

	@Phone
	private String phone;
	
	@Column(name = "status")
	private String status;

	private String username;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="invoice", fetch=FetchType.EAGER)
	private List<InvoiceDetailEntity> invoiceDetail;

	public InvoiceEntity() {
	}

	public InvoiceEntity(Date created, String email, String phone, String status, String username,
			String firstName, String lastName, String address, String city, List<InvoiceDetailEntity> invoiceDetail) {
		super();
		this.created = created;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.invoiceDetail = invoiceDetail;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<InvoiceDetailEntity> getInvoiceDetail() {
		return this.invoiceDetail;
	}

	public void setInvoiceDetail(List<InvoiceDetailEntity> invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}
}