package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.guru.validator.Phone;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table (name = "user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name = "username")
	@Size(min = 8, max = 20)
	private String username;
	
	@NotBlank
	@Column(name = "address")
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;
	
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
	@Column(name = "password")
	private String password;
	
	@Phone
	@Column(name = "phone")
	private String phone;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns={
					@JoinColumn(name = "user_id")
			}
			,inverseJoinColumns={
					@JoinColumn(name = "role_id")
			}
			)
	private List<RoleEntity> roles;
	
	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public UserEntity() {
	}
	
	public UserEntity(String id) {
		super();
		this.id = id;
	}

	public UserEntity(String username, String address, Date created, String email, String password,
			String phone) {
		super();
		this.username = username;
		this.address = address;
		this.created = created;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}