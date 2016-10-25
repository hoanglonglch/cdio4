package com.guru.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ParentEntity;
import com.guru.repository.CategoryEntityRepository;
import com.guru.repository.ParentEntityRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@Autowired
	ParentEntityRepository parentEntityRepository;
	
	@Autowired
	CategoryEntityRepository categoryEntityRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<ParentEntity> parent = new ArrayList<ParentEntity>();
		parent = parentEntityRepository.findAll();
		for (ParentEntity parentEntity : parent) {
			System.out.println(parentEntity.getId() + parentEntity.getParent() + parentEntity.getCategories());
		}
		List<CategoryEntity> category = new ArrayList<CategoryEntity>();
		category = categoryEntityRepository.findAll();
		for (CategoryEntity categoryEntity : category) {
			System.out.println(categoryEntity.getId() + categoryEntity.getCategory() + categoryEntity.getParent());
		}
		return "homePage";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {

		return "contact";
	}
}
