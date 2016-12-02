package com.guru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.entities.InvoiceDetailEntity;
import com.guru.repository.InvoiceDetailEntityRepository;

@Service
public class InvoiceDetailEntityManagerImpl implements InvoiceDetailEntityManager{
	@Autowired
	private InvoiceDetailEntityRepository invoiceDetailEntityRepository;

	@Override
	public List<InvoiceDetailEntity> getAllDetail() {
		// TODO Auto-generated method stub
		return invoiceDetailEntityRepository.findAll();
	}

	@Override
	public void saveInvoiceDetail(InvoiceDetailEntity detailEntity) {
		// TODO Auto-generated method stub
		invoiceDetailEntityRepository.save(detailEntity);
	}

	@Override
	public void deleteInvoiceDetail(InvoiceDetailEntity detailEntity) {
		// TODO Auto-generated method stub
		invoiceDetailEntityRepository.delete(detailEntity);
	}

	@Override
	public List<InvoiceDetailEntity> findByInvoiceId(String invoiceId) {
		// TODO Auto-generated method stub
		return invoiceDetailEntityRepository.findByInvoiceId(invoiceId);
	}

	@Override
	public InvoiceDetailEntity findById(String id) {
		// TODO Auto-generated method stub
		return invoiceDetailEntityRepository.findOne(id);
	}

	@Override
	public void deleteInvoiceWhenDeleteInvoice(List<InvoiceDetailEntity> invoiceDetailEntities) {
		// TODO Auto-generated method stub
		invoiceDetailEntityRepository.deleteInBatch(invoiceDetailEntities);
	}
	
}
