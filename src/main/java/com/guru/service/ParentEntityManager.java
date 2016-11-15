package com.guru.service;

import java.util.List;

import com.guru.entities.ParentEntity;

public interface ParentEntityManager {
	List<ParentEntity> getAllParent();
	void deleteParent(ParentEntity parentEntity);
}
