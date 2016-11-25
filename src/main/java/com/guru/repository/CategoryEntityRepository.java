package com.guru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.CategoryEntity;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, String> {
	List<CategoryEntity> findByParentId(String id);
	CategoryEntity findById(String id);
	CategoryEntity findByCategory(String category);
}
