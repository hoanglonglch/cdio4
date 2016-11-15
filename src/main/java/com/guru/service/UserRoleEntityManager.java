package com.guru.service;

import com.guru.entities.UserRoleEntity;

public interface UserRoleEntityManager {
	void saveUserRole(UserRoleEntity userRoleEntity);
	void deleteUserRole(UserRoleEntity userRoleEntity);
}
