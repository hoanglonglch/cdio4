package com.guru.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.CategoryEntity;
import com.guru.service.CategoryEntityManager;
import com.guru.service.ParentEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageCategoryController {
	private static final Logger logger = LoggerFactory.getLogger(ManageCategoryController.class);
	
	@Autowired
	CategoryEntityManager categoryEntityManager;
	
	@Autowired
	ParentEntityManager parentEntityManager;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("categoryEntities",categoryEntityManager.getAllCategory());
		return "manageCategoryPage";
	}
	@RequestMapping(value = "/category/delete?id", method = RequestMethod.POST)
	public String deleteCategory(@PathVariable("id") String id, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		CategoryEntity categoryEntity = categoryEntityManager.findCategoryById(id);
		categoryEntityManager.deleteCategory(categoryEntity);
		return "manageCategoryPage";
	}
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public String createCategory(HttpServletRequest request, Locale locale, ModelMap model) {
		String category = request.getParameter("category");
		String parent = request.getParameter("parent");
		logger.info("Welcome home! The client locale is {}.", locale);
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategory(category);
		categoryEntity.setParent(parentEntityManager.findByParent(parent));
		categoryEntityManager.saveCategory(categoryEntity);
		return "manageCategoryPage";
	}
}
