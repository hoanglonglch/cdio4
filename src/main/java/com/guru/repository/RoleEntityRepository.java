package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, String>{
	RoleEntity findByName(String roleName);
}
