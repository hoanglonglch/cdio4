package com.guru.service;

import java.util.List;

import com.guru.entities.InvoiceDetailEntity;

public interface InvoiceDetailEntityManager {
	List<InvoiceDetailEntity> findByInvoiceId(String invoiceId);
	List<InvoiceDetailEntity> getAllDetail();
	void saveInvoiceDetail(InvoiceDetailEntity detailEntity);
	void deleteInvoiceDetail(InvoiceDetailEntity detailEntity);
	InvoiceDetailEntity findById(String id);
}
