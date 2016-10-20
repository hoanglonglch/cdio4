package com.guru.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRoleEntity.findAll", query="SELECT u FROM UserRoleEntity u")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role")
	private RoleEntity roleBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private UserEntity user;

	public UserRoleEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleEntity getRoleBean() {
		return this.roleBean;
	}

	public void setRoleBean(RoleEntity roleBean) {
		this.roleBean = roleBean;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}