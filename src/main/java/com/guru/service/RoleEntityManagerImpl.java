package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.repository.RoleEntityRepository;

@Service
@Transactional
public class RoleEntityManagerImpl implements RoleEntityManager{
	@Autowired
	private RoleEntityRepository roleEntityRepository;
}
