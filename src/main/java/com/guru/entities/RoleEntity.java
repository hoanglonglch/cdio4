package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table (name = "role")
@NamedQuery(name="RoleEntity.findAll", query="SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	@ManyToMany(mappedBy = "roles", fetch=FetchType.LAZY)
	private List<UserEntity> users;

	public RoleEntity() {
	}
	
	public RoleEntity(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}