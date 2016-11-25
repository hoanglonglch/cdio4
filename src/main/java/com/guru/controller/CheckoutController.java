package com.guru.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.CartEntity;
import com.guru.entities.InvoiceDetailEntity;
import com.guru.entities.InvoiceEntity;
import com.guru.service.InvoiceDetailEntityManager;
import com.guru.service.InvoiceEntityManager;
import com.guru.service.ParentEntityManager;

@Controller
@RequestMapping(value = "/")
public class CheckoutController {
	private static Logger logger = LoggerFactory.getLogger(CheckoutController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ParentEntityManager parentEntityManager;
	@Autowired
	InvoiceEntityManager invoiceEntityManager;
	@Autowired
	InvoiceDetailEntityManager detailEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(ModelMap modelMap) {
		modelMap.addAttribute("invoiceEntity",new InvoiceEntity());
		return "checkoutPage";
	}
	@RequestMapping(value = "/comfirmCheckout", method = RequestMethod.POST)
	public String checkoutAdd(@Valid InvoiceEntity invoiceEntity,
			BindingResult bindingResult,
			ModelMap modelMap, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		@SuppressWarnings("unchecked")
		List<CartEntity> carts = (List<CartEntity>)session.getAttribute("cartSession");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String username = request.getUserPrincipal().getName();
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "checkoutPage";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		
		try {
			InvoiceEntity invoiceEntityAdd = new InvoiceEntity(Calendar.getInstance().getTime(),
					email, phone, "1", username, firstName, lastName, address, city, null);
			invoiceEntityManager.saveInvoice(invoiceEntityAdd);
			for(CartEntity cart : carts){
				InvoiceDetailEntity detailEntity = new InvoiceDetailEntity(cart.getProductEntity().getPrice()*cart.getQuantity(),
						cart.getQuantity(), invoiceEntityAdd, cart.getProductEntity());
				detailEntityManager.saveInvoiceDetail(detailEntity);
			}
			session.removeAttribute("cartSession");
		} catch (NullPointerException e) {
			// TODO: handle exception
			return "cartPage";
		}
		
		return "homePage";
	}
}