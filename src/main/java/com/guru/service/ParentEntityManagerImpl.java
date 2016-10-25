package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.repository.ParentEntityRepository;

@Service
public class ParentEntityManagerImpl implements ParentEntityManager{
	@Autowired
	ParentEntityRepository parentEntityRepository;
}
