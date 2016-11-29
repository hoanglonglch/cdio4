package com.guru.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.entities.InvoiceDetailEntity;
import com.guru.entities.InvoiceEntity;
import com.guru.service.InvoiceDetailEntityManager;
import com.guru.service.InvoiceEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageInvoiceController {
	private static final Logger logger = LoggerFactory.getLogger(ManageInvoiceController.class);
	@Autowired
	InvoiceEntityManager invoiceEntityManager;
	
	@Autowired
	InvoiceDetailEntityManager invoiceDetailEntityManager;
	
	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public String invoice(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("invoiceEntities",invoiceEntityManager.getAll());
		return "manageInvoicePage";
	}
	@RequestMapping(value = "/invoice/delete", method = RequestMethod.GET)
	public String deleteInvoice(@RequestParam("id") String id, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		InvoiceEntity invoiceEntity = invoiceEntityManager.findById(id);
		List<InvoiceDetailEntity> invoiceDetailEntities = invoiceEntity.getInvoiceDetail();
		for (InvoiceDetailEntity invoiceDetailEntity : invoiceDetailEntities) {
			invoiceDetailEntityManager.deleteInvoiceDetail(invoiceDetailEntity);
		}
		invoiceEntityManager.deleteInvoice(invoiceEntity);
		return "redirect:invoice";
	}
}
