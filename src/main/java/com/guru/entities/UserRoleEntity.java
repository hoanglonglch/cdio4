package com.guru.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idUS")
	private String idUS;
	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private RoleEntity role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity user;

	public UserRoleEntity() {
	}
	
	public UserRoleEntity(RoleEntity role, UserEntity user, String id) {
		super();
		this.idUS=id;
		this.role = role;
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUS == null) ? 0 : idUS.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleEntity other = (UserRoleEntity) obj;
		if (idUS == null) {
			if (other.idUS != null)
				return false;
		} else if (!idUS.equals(other.idUS))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public String getIdUS() {
		return idUS;
	}

	public void setIdUS(String idUS) {
		this.idUS = idUS;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public RoleEntity getRoleBean() {
		return this.role;
	}

	public void setRoleBean(RoleEntity role) {
		this.role = role;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}