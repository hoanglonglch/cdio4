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
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ParentEntity;
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
		model.addAttribute("parents",parentEntityManager.getAllParent());
		model.addAttribute("categoryEntity", new CategoryEntity());
		model.addAttribute("categoryEntities",categoryEntityManager.getAllCategory());
		return "manageCategoryPage";
	}
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam("id") String id, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println(id);
		categoryEntityManager.deleteCategory(id);
		return "redirect:category";
	}
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String createCategory(HttpServletRequest request, Locale locale, ModelMap model) {
		String category = request.getParameter("category");
		String parent = request.getParameter("parent");
		System.out.println(parent);
		logger.info("Welcome home! The client locale is {}.", locale);
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategory(category);
		ParentEntity parentEntity = parentEntityManager.findByParent(parent);
		categoryEntity.setParent(parentEntity);
		categoryEntityManager.saveCategory(categoryEntity);
		return "redirect:category";
	}
}
