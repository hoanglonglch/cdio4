package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.repository.InvoiceEntityRepository;

@Service
public class InvoiceEntityManagerImpl implements InvoiceEntityManager{
	@Autowired
	InvoiceEntityRepository invoiceEntityRepository;
}
