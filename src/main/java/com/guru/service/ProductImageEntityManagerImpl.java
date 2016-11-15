package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.ProductEntity;
import com.guru.entities.ProductImageEntity;
import com.guru.repository.ProductImageEntityRepository;

@Service
public class ProductImageEntityManagerImpl implements ProductImageEntityManager {

	@Autowired
	ProductImageEntityRepository productImageEntityRepository;
	
	@Override
	public List<ProductImageEntity> getByProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return productImageEntityRepository.findByProduct(productEntity);
	}
	
}
