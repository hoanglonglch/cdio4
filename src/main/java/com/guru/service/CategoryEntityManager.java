package com.guru.service;

import java.util.List;

import com.guru.entities.CategoryEntity;

public interface CategoryEntityManager{
	List<CategoryEntity> getAllCategory();
	List<CategoryEntity> findCategoryByParent(String id);
	CategoryEntity findCategoryById(String id);
	void deleteCategory(CategoryEntity categoryEntity);
	void saveCategory(CategoryEntity categoryEntity);
	CategoryEntity findByName(String category);
}
