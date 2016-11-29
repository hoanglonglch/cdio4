package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
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
	public void deleteUserRole(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		
		userRoleEntityRepository.delete(userRoleEntity);
	}

	@Override
	public UserRoleEntity findByUserEntity(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userRoleEntityRepository.findByUser(userEntity);
	}

	@Override
	public void saveUserRole(String role_id, String user_id) {
		// TODO Auto-generated method stub
		userRoleEntityRepository.save(new UserRoleEntity(new RoleEntity(role_id),new UserEntity(user_id)));
	}

}
