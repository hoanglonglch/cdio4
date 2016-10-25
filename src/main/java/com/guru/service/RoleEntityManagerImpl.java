package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.repository.RoleEntityRepository;

@Service
public class RoleEntityManagerImpl implements RoleEntityManager{
	@Autowired
	RoleEntityRepository roleEntityRepository;
}
