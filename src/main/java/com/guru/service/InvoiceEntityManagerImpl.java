package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guru.repository.InvoiceEntityRepository;

@Service
@Transactional
public class InvoiceEntityManagerImpl implements InvoiceEntityManager{
	@Autowired
	private InvoiceEntityRepository invoiceEntityRepository;
}
