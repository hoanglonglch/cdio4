package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.entities.CategoryEntity;
import com.guru.repository.CategoryEntityRepository;

@Service
@Transactional
public class CategoryEntityManagerImpl implements CategoryEntityManager {
	@Autowired
	private CategoryEntityRepository categoryEntityRepository;

	public List<CategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findAll();
	}

	public List<CategoryEntity> findCategoryByParent(String id) {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findCategoryByParentId(id);
	}
	
}
