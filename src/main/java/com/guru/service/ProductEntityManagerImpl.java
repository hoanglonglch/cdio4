package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.repository.ProductEntityRepository;

@Service
public class ProductEntityManagerImpl implements ProductEntityManager{
	@Autowired
	ProductEntityRepository productEntityRepository;
}
