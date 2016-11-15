package com.guru.service;

import java.util.List;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ProductEntity;

public interface ProductEntityManager {
	ProductEntity findOne(String id);
	List<ProductEntity> findByCategory(CategoryEntity categoryEntity);
	List<ProductEntity> findAll();
	List<ProductEntity> findProductFeature();
	List<ProductEntity> findProductLatest();
	void saveProduct(ProductEntity productEntity);
	void deleteProduct(ProductEntity productEntity);
}
