package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.entities.DetailEntity;
import com.guru.repository.DetailEntityRepository;

@Service
@Transactional
public class DetailEntityManagerImpl implements DetailEntityManager{
	@Autowired
	private DetailEntityRepository detailEntityRepository;

	public List<DetailEntity> getAllDetail() {
		// TODO Auto-generated method stub
		return detailEntityRepository.findAll();
	}
	
}
