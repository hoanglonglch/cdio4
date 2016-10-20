package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {

	public UserEntity findByUsername(String username);
}
