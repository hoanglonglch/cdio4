package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.DetailEntity;

@Repository
public interface DetailEntityRepository extends JpaRepository<DetailEntity, String>{

}
