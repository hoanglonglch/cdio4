package com.guru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.guru.entities.ParentEntity;
import com.guru.service.ParentEntityManager;

@Controller
@RequestMapping(value = "/")
public class ParentController {
	@Autowired
	ParentEntityManager parentEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/getAllParent", method = RequestMethod.GET)
	public ResponseEntity<List<ParentEntity>> home(ModelMap modelMap) {

		List<ParentEntity> list = parentEntityManager.getAllParent();
		if (list.isEmpty()) {
			return new ResponseEntity<List<ParentEntity>>(
					HttpStatus.NO_CONTENT);// You many decide to return
											// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ParentEntity>>(list, HttpStatus.OK);
	}
}
