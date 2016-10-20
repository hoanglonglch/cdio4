package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String name;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="roleBean")
	private List<UserRoleEntity> userRoles;

	public RoleEntity() {
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

	public List<UserRoleEntity> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRoleEntity addUserRole(UserRoleEntity userRole) {
		getUserRoles().add(userRole);
		userRole.setRoleBean(this);

		return userRole;
	}

	public UserRoleEntity removeUserRole(UserRoleEntity userRole) {
		getUserRoles().remove(userRole);
		userRole.setRoleBean(null);

		return userRole;
	}

}