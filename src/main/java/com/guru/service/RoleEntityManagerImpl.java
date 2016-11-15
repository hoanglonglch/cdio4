package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.RoleEntity;
import com.guru.repository.RoleEntityRepository;

@Service
public class RoleEntityManagerImpl implements RoleEntityManager{
	@Autowired
	RoleEntityRepository roleEntityRepository;
	
	public List<RoleEntity> getAll() {
		// TODO Auto-generated method stub
		return roleEntityRepository.findAll();
	}

	@Override
	public void saveRoleEntity(RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		roleEntityRepository.save(roleEntity);
	}

	@Override
	public void deleteRoleEntity(RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		roleEntityRepository.delete(roleEntity);
	}

	@Override
	public RoleEntity getByName(String roleName) {
		// TODO Auto-generated method stub
		return roleEntityRepository.findByName(roleName);
	}
}
