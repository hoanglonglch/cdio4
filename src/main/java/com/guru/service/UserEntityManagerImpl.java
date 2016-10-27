package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.entities.UserEntity;
import com.guru.repository.UserEntityRepository;

@Service
@Transactional
public class UserEntityManagerImpl implements UserEntityManager{
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return userEntityRepository.save(user);
	}

	public UserEntity getByUsername(String username) {
		// TODO Auto-generated method stub
		return userEntityRepository.findByUsername(username);
	}
}
