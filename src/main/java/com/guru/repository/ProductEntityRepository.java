package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.ProductEntity;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {

}
