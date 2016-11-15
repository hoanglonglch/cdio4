package com.guru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.CategoryEntity;
import com.guru.entities.ProductEntity;
import com.guru.service.CategoryEntityManager;
import com.guru.service.ParentEntityManager;
import com.guru.service.ProductEntityManager;

@Controller
@RequestMapping(value = "/")
public class ProductController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ParentEntityManager parentEntityManager;
	@Autowired
	ProductEntityManager productEntityManager;
	@Autowired
	CategoryEntityManager categoryEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/productsByParent/{id}", method = RequestMethod.GET)
	public String productByParent(@PathVariable("id") String parent_id, ModelMap modelMap) {
		List<CategoryEntity> categoryEntities = categoryEntityManager.findCategoryByParent(parent_id);
		List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
		for(CategoryEntity categoryEntity : categoryEntities){
			List<ProductEntity> products = productEntityManager.findByCategory(categoryEntity);
			productEntities.addAll(products);
		}
		modelMap.addAttribute("products",productEntities);
		return "productPage";
	}
	@RequestMapping(value = "/productsByCategory/{id}", method = RequestMethod.GET)
	public String productByCategory(@PathVariable("id") String category_id, ModelMap modelMap) {
		CategoryEntity categoryEntity = categoryEntityManager.findCategoryById(category_id);
		List<ProductEntity> productEntities = productEntityManager.findByCategory(categoryEntity);
		modelMap.addAttribute("products",productEntities);
		return "productPage";
	}
}
