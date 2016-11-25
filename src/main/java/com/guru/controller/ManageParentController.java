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

import com.guru.entities.ParentEntity;
import com.guru.service.ParentEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageParentController {
	private static final Logger logger = LoggerFactory.getLogger(ManageParentController.class);
	@Autowired
	ParentEntityManager parentEntityManager;
	
	@RequestMapping(value = "/parent", method = RequestMethod.GET)
	public String parent(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("parentEntities",parentEntityManager.getAllParent());
		return "manageParentPage";
	}
	@RequestMapping(value = "/parent/delete", method = RequestMethod.GET)
	public String deleteParent(@PathVariable("id") String id, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ParentEntity parentEntity = parentEntityManager.findByParent(id);
		parentEntityManager.deleteParent(parentEntity);
		return "manageCategoryPage";
	}
	@RequestMapping(value = "/parent/create", method = RequestMethod.POST)
	public String createParent(HttpServletRequest request, Locale locale, ModelMap model) {
		String parent = request.getParameter("parent");
		logger.info("Welcome home! The client locale is {}.", locale);
		ParentEntity parentEntity = new ParentEntity();
		parentEntity.setParent(parent);
		parentEntityManager.saveParent(parentEntity);
		return "manageCategoryPage";
	}
}
