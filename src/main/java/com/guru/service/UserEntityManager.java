package com.guru.service;

import java.util.List;

import com.guru.entities.UserEntity;

public interface UserEntityManager {
	void saveUserEntity(UserEntity userEntity);
	void deleteUserEntity(UserEntity userEntity);
	UserEntity getByUsername(String username);
	List<UserEntity> findAll();
}
