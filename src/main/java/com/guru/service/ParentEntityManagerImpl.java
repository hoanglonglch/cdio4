package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.ParentEntity;
import com.guru.repository.ParentEntityRepository;

@Service
public class ParentEntityManagerImpl implements ParentEntityManager{
	@Autowired
	private ParentEntityRepository parentEntityRepository;
	
	@Override
	public List<ParentEntity> getAllParent() {
		// TODO Auto-generated method stub
		return parentEntityRepository.findAll();
	}

	@Override
	public void deleteParent(ParentEntity parentEntity) {
		// TODO Auto-generated method stub
		parentEntityRepository.delete(parentEntity);
	}

	@Override
	public ParentEntity findByParent(String parent) {
		// TODO Auto-generated method stub
		return parentEntityRepository.findByParent(parent);
	}

	@Override
	public void saveParent(ParentEntity parentEntity) {
		// TODO Auto-generated method stub
		parentEntityRepository.save(parentEntity);
	}
}
