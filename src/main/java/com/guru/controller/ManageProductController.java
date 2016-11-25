package com.guru.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ProductEntity;
import com.guru.service.CategoryEntityManager;
import com.guru.service.ProductEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageProductController {
	private static final Logger logger = LoggerFactory.getLogger(ManageProductController.class);
	@Autowired
	ProductEntityManager productEntityManager;
	@Autowired
	CategoryEntityManager categoryEntityManager;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("productEntities",productEntityManager.findAll());
		return "manageProductPage";
	}
	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
	public String createProduct(HttpServletRequest request, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String category = request.getParameter("category");
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(name);
		productEntity.setDescription(description);
		productEntity.setPrice(price);
		productEntity.setQuantity(quantity);
		CategoryEntity categoryEntity = categoryEntityManager.findByName(category);
		productEntity.setCategory(categoryEntity);
		model.addAttribute("productEntities",productEntityManager.findAll());
		return "manageProductPage";
	}
}
