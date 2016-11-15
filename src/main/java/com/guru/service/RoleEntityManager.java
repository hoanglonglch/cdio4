package com.guru.service;

import java.util.List;

import com.guru.entities.RoleEntity;

public interface RoleEntityManager {
	List<RoleEntity> getAll();
	RoleEntity getByName(String roleName);
	void saveRoleEntity(RoleEntity roleEntity);
	void deleteRoleEntity(RoleEntity roleEntity);
}
