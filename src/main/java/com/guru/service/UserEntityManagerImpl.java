package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.UserEntity;
import com.guru.repository.UserEntityRepository;

@Service
public class UserEntityManagerImpl implements UserEntityManager{
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	public void saveUserEntity(UserEntity user) {
		// TODO Auto-generated method stub
		userEntityRepository.save(user);
	}

	public UserEntity getByUsername(String username) {
		// TODO Auto-generated method stub
		return userEntityRepository.findByUsername(username);
	}

	@Override
	public void deleteUserEntity(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntityRepository.delete(userEntity);
	}
}
