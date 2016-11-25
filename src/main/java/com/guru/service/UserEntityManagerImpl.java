package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.UserEntity;
import com.guru.repository.UserEntityRepository;

@Service
public class UserEntityManagerImpl implements UserEntityManager{
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public void saveUserEntity(UserEntity user) {
		// TODO Auto-generated method stub
		userEntityRepository.save(user);
	}

	@Override
	public UserEntity getByUsername(String username) {
		// TODO Auto-generated method stub
		return userEntityRepository.findByUsername(username);
	}

	@Override
	public void deleteUserEntity(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntityRepository.delete(userEntity);
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userEntityRepository.findAll();
	}
}
