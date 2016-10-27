package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.repository.ProductEntityRepository;

@Service
@Transactional
public class ProductEntityManagerImpl implements ProductEntityManager{
	@Autowired
	private ProductEntityRepository productEntityRepository;
}
