package com.guru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.entities.InvoiceDetailEntity;

@Repository
public interface InvoiceDetailEntityRepository extends JpaRepository<InvoiceDetailEntity, String>{
	List<InvoiceDetailEntity> findByInvoiceId(String invoiceId);
}
