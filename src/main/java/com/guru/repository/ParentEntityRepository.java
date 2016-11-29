package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.ParentEntity;

@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, String>{
	ParentEntity findByParent(String parent);
}
