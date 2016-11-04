package com.guru.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.service.ParentEntityManager;

/**
 * Handles requests for the application home page.
 */

@Transactional
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	@Autowired
	ParentEntityManager parentEntityManager;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ModelAttribute("parent")
	public void parent(){
		parentEntityManager.getAllParent();
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap model) {
		return "homePage";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {

		return "contactPage";
	}
}
