package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.ImageEntity;

@Repository
public interface ImageEntityRepository extends JpaRepository<ImageEntity, String>{
	ImageEntity findById(String id);
}
