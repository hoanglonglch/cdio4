package com.guru.service;

import java.util.List;

import com.guru.entities.InvoiceEntity;

public interface InvoiceEntityManager {
	void saveInvoice(InvoiceEntity invoiceEntity);
	void deleteInvoice(InvoiceEntity invoiceEntity);
	List<InvoiceEntity> getAll();
	InvoiceEntity findById(String id);
}
