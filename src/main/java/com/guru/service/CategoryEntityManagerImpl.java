package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.CategoryEntity;
import com.guru.repository.CategoryEntityRepository;

@Service
public class CategoryEntityManagerImpl implements CategoryEntityManager {
	@Autowired
	CategoryEntityRepository categoryEntityRepository;

	public List<CategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findAll();
	}
	
}
