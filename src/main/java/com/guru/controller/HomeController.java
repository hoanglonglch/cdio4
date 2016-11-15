package com.guru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.ProductEntity;
import com.guru.service.ParentEntityManager;
import com.guru.service.ProductEntityManager;

/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {
	@Autowired
	ParentEntityManager parentEntityManager;
	
	@Autowired
	ProductEntityManager productEntityManager;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@ModelAttribute
	public void productFeature(ModelMap modelMap){
		List<ProductEntity> productFeatures = productEntityManager.findProductFeature();
		modelMap.addAttribute("productFeatures",productFeatures);
	}
	@ModelAttribute
	public void productLatest(ModelMap modelMap){
		List<ProductEntity> productLatests = productEntityManager.findProductLatest();
		for(ProductEntity productEntity : productLatests){
			System.out.println(productEntity.getName());
		}
		modelMap.addAttribute("productLatests",productLatests);
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "homePage";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {

		return "contactPage";
	}
}
