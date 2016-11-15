package com.guru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.ProductEntity;
import com.guru.entities.ProductImageEntity;

@Repository
public interface ProductImageEntityRepository extends JpaRepository<ProductImageEntity, String>{
	List<ProductImageEntity> findByProduct(ProductEntity productEntity);
}
