package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ProductEntity;
import com.guru.repository.ProductEntityRepository;

@Service
public class ProductEntityManagerImpl implements ProductEntityManager{
	
	@Autowired
	ProductEntityRepository productEntityRepository;
	public ProductEntity findOne(String id) {
		// TODO Auto-generated method stub
		return productEntityRepository.findOne(id);
	}
	@Override
	public List<ProductEntity> findByCategory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		return productEntityRepository.findByCategory(categoryEntity);
	}
	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		return productEntityRepository.findAll();
	}
	@Override
	public List<ProductEntity> findProductFeature() {
		// TODO Auto-generated method stub
		return productEntityRepository.findProductFeature();
	}
	@Override
	public void saveProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		productEntityRepository.save(productEntity);
	}
	@Override
	public void deleteProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		productEntityRepository.delete(productEntity);
	}
	@Override
	public List<ProductEntity> findProductLatest() {
		// TODO Auto-generated method stub
		return productEntityRepository.findTop8ByCreated(new PageRequest(0, 8, Direction.DESC, "created"));
	}
}
