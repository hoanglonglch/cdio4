package com.guru.service;

import java.util.List;

import com.guru.entities.CategoryEntity;

public interface CategoryEntityManager{
	
	public List<CategoryEntity> getAllCategory();
	
	public List<CategoryEntity> findCategoryByParent(String id);
}
