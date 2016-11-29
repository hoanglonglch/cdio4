package com.guru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guru.entities.CategoryEntity;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, String> {
	List<CategoryEntity> findByParentId(String id);
	CategoryEntity findById(String id);
	CategoryEntity findByCategory(String category);
	@Modifying
	@Query("DELETE FROM CategoryEntity WHERE id= :id")
	void delete(@Param("id") String id);
}
