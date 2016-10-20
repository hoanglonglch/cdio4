package com.guru.service;

import com.guru.entities.UserEntity;

public interface UserEntityManager {
	UserEntity saveUser(UserEntity user);
	UserEntity getByUsername(String username);
}
