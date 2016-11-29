package com.guru.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.entities.InvoiceDetailEntity;
import com.guru.service.InvoiceDetailEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageInvoiceDetailController {
	private static final Logger logger = LoggerFactory.getLogger(ManageInvoiceDetailController.class);
	@Autowired
	InvoiceDetailEntityManager invoiceDetailEntityManager;
	
	@RequestMapping(value = "/invoiceDetail/{invoiceId}", method = RequestMethod.GET)
	public String detailInvoice(@PathVariable("invoiceId") String invoiceId,Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("invoiceDetailEntities",invoiceDetailEntityManager.findByInvoiceId(invoiceId));
		return "manageInvoiceDetailPage";
	}
	
	@RequestMapping(value = "/invoiceDetail/delete", method = RequestMethod.GET)
	public String deleteInvoiceDetail(@RequestParam("id") String id, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		InvoiceDetailEntity invoiceDetailEntitiy = invoiceDetailEntityManager.findById(id);
		invoiceDetailEntityManager.deleteInvoiceDetail(invoiceDetailEntitiy);
		return "redirect:invoiceDetail/{invoiceId}";
	}
}
