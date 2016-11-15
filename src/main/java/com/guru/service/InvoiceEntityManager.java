package com.guru.service;

import com.guru.entities.InvoiceEntity;

public interface InvoiceEntityManager {

	void saveInvoice(InvoiceEntity invoiceEntity);
	
	void deleteInvoice(InvoiceEntity invoiceEntity);
}
