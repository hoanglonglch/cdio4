package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.ImageEntity;
import com.guru.repository.ImageEntityRepository;

@Service
public class ImageEntityManagerImpl implements ImageEntityManager {
	
	@Autowired
	ImageEntityRepository imageEntityRepository;
	@Override
	public ImageEntity getById(String id) {
		// TODO Auto-generated method stub
		return imageEntityRepository.findById(id);
	}

}
