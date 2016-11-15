package com.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.InvoiceEntity;
import com.guru.repository.InvoiceEntityRepository;

@Service
public class InvoiceEntityManagerImpl implements InvoiceEntityManager{
	
	@Autowired
	InvoiceEntityRepository invoiceEntityRepository;
	@Override
	public void saveInvoice(InvoiceEntity invoiceEntity) {
		// TODO Auto-generated method stub
		invoiceEntityRepository.save(invoiceEntity);
	}
	@Override
	public void deleteInvoice(InvoiceEntity invoiceEntity) {
		// TODO Auto-generated method stub
		invoiceEntityRepository.delete(invoiceEntity);
	}
}
