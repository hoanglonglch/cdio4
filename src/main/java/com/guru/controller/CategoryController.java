package com.guru.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.guru.entities.CategoryEntity;
import com.guru.service.CategoryEntityManager;

@Controller
@RequestMapping(value = "/")
public class CategoryController {
	@Autowired
	CategoryEntityManager categoryEntityManager;
	
	@RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryEntity>> home(Locale locale, Model model) {

		List<CategoryEntity> list = categoryEntityManager.getAllCategory();
		if (list.isEmpty()) {
			return new ResponseEntity<List<CategoryEntity>>(
					HttpStatus.NO_CONTENT);// You many decide to return
											// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CategoryEntity>>(list, HttpStatus.OK);
	}
}
