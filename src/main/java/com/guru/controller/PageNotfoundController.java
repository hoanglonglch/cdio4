package com.guru.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Controller
public class PageNotfoundController {
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	 public String accessDenied(ModelMap modelMap, Principal principal) {
	  String username = principal.getName();
	  modelMap.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
	  return "403";
	 }
}
