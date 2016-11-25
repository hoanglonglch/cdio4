package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.UserRoleEntity;
import com.guru.repository.RoleEntityRepository;
import com.guru.repository.UserEntityRepository;
import com.guru.repository.UserRoleEntityRepository;
@Service
public class UserRoleEntityManagerImpl implements UserRoleEntityManager {
	@Autowired
	UserRoleEntityRepository userRoleEntityRepository;
	
	@Autowired
	RoleEntityRepository roleEntityRepository;
	
	@Autowired
	UserEntityRepository userEntityRepository;
	
	@Override
	public void saveUserRole(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		userRoleEntityRepository.save(userRoleEntity);		
	}

	@Override
	public void deleteUserRole(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		
		userRoleEntityRepository.delete(userRoleEntity);
	}

}
