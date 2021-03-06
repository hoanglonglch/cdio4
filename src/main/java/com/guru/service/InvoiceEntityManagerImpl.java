package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.InvoiceDetailEntity;
import com.guru.entities.InvoiceEntity;
import com.guru.repository.InvoiceEntityRepository;

@Service
public class InvoiceEntityManagerImpl implements InvoiceEntityManager{
	
	@Autowired
	InvoiceEntityRepository invoiceEntityRepository;
	
	@Autowired
	InvoiceDetailEntityManager invoiceDetailEntityManager;
	@Override
	public void saveInvoice(InvoiceEntity invoiceEntity) {
		// TODO Auto-generated method stub
		invoiceEntityRepository.save(invoiceEntity);
	}
	@Override
	public void deleteInvoice(InvoiceEntity invoiceEntity) {
		// TODO Auto-generated method stub
		List<InvoiceDetailEntity> invoiceDetailEntities = invoiceDetailEntityManager.findByInvoiceId(invoiceEntity.getId());
		invoiceDetailEntityManager.deleteInvoiceWhenDeleteInvoice(invoiceDetailEntities);
		invoiceEntityRepository.delete(invoiceEntity);
	}
	@Override
	public List<InvoiceEntity> getAll() {
		// TODO Auto-generated method stub
		return invoiceEntityRepository.findAll();
	}
	@Override
	public InvoiceEntity findById(String id) {
		// TODO Auto-generated method stub
		return invoiceEntityRepository.findOne(id);
	}
}
