package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.entities.ParentEntity;
import com.guru.repository.ParentEntityRepository;

@Service
@Transactional
public class ParentEntityManagerImpl implements ParentEntityManager{
	@Autowired
	private ParentEntityRepository parentEntityRepository;

	public List<ParentEntity> getAllParent() {
		// TODO Auto-generated method stub
		return parentEntityRepository.findAll();
	}
}
