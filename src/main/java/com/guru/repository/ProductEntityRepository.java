package com.guru.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ProductEntity;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {
	List<ProductEntity> findByCategory(CategoryEntity category);
	@Query("SELECT p FROM ProductEntity p WHERE p.price > 10000")
	List<ProductEntity> findProductFeature();
	@Query("SELECT p FROM ProductEntity p")
	List<ProductEntity> findTop8ByCreated(Pageable pageable);
}
