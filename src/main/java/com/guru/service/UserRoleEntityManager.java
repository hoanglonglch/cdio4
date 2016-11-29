package com.guru.service;

import com.guru.entities.UserEntity;
import com.guru.entities.UserRoleEntity;

public interface UserRoleEntityManager {
	void saveUserRole(String role_id,String user_id);
	void deleteUserRole(UserRoleEntity userRoleEntity);
	UserRoleEntity findByUserEntity(UserEntity userEntity);
} 
