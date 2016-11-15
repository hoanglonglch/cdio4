package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.CategoryEntity;
import com.guru.repository.CategoryEntityRepository;

@Service
public class CategoryEntityManagerImpl implements CategoryEntityManager {
	@Autowired
	private CategoryEntityRepository categoryEntityRepository;

	public List<CategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findAll();
	}

	public List<CategoryEntity> findCategoryByParent(String id) {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findByParentId(id);
	}

	@Override
	public CategoryEntity findCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryEntityRepository.findById(id);
	}

	@Override
	public void deleteCategory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		categoryEntityRepository.delete(categoryEntity);
	}

	@Override
	public void saveCategory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		categoryEntityRepository.save(categoryEntity);
	}
}
