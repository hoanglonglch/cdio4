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

import com.guru.entities.ImageEntity;
import com.guru.entities.ProductEntity;
import com.guru.entities.ProductImageEntity;
import com.guru.service.CategoryEntityManager;
import com.guru.service.ImageEntityManager;
import com.guru.service.ParentEntityManager;
import com.guru.service.ProductEntityManager;
import com.guru.service.ProductImageEntityManager;

@Controller
@RequestMapping(value = "/")
public class ProductDetailController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ParentEntityManager parentEntityManager;
	@Autowired
	ProductEntityManager productEntityManager;
	@Autowired
	CategoryEntityManager categoryEntityManager;
	@Autowired
	ProductImageEntityManager productImageEntityManager;
	@Autowired
	ImageEntityManager imageEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/product_detail/{id}", method = RequestMethod.GET)
	public String home(@PathVariable("id")String id,ModelMap modelMap) {
		ProductEntity productEntity = productEntityManager.findOne(id);
		List<ProductEntity> productEntities = productEntityManager.findByCategory(productEntity.getCategory());
		List<ProductImageEntity> productImageEntities = productImageEntityManager.getByProduct(productEntity);
		List<ImageEntity> imageEntities = new ArrayList<ImageEntity>();
		for(ProductImageEntity productImageEntity : productImageEntities){
			imageEntities.add(imageEntityManager.getById(productImageEntity.getImage().getId()));
		}
		modelMap.addAttribute("product_detail",productEntity);
		modelMap.addAttribute("imageEntities",imageEntities);
		modelMap.addAttribute("products",productEntities);
		return "product_detailPage";
	}
}
