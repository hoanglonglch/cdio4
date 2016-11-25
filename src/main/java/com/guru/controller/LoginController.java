package com.guru.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
import com.guru.entities.UserRoleEntity;
import com.guru.service.ParentEntityManager;
import com.guru.service.RoleEntityManager;
import com.guru.service.UserEntityManager;
import com.guru.service.UserRoleEntityManager;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ParentEntityManager parentEntityManager;
	@Autowired
	UserEntityManager userEntityManager;
	@Autowired
	UserRoleEntityManager userRoleEntityManager;
	@Autowired
	RoleEntityManager roleEntityManager;
	@ModelAttribute("parent")
	public void parent(ModelMap model){
		model.addAttribute("parent",parentEntityManager.getAllParent());
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("userEntity",new UserEntity());
		return "loginPage";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid UserEntity userEntity,
			BindingResult bindingResult, HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "loginPage";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		if(userEntityManager.getByUsername(username) != null ){
			
		}else{
			UserEntity userEntityAdd = new UserEntity(username, address, Calendar.getInstance().getTime(),
					email, password, phone);
			userEntityManager.saveUserEntity(userEntityAdd);
			RoleEntity roleEntity = roleEntityManager.getByName("ROLE_USER");
			UserRoleEntity userRoleEntity = new UserRoleEntity(roleEntity, userEntityAdd);
			userRoleEntityManager.saveUserRole(userRoleEntity);
		}
		return "loginPage";
	}
}
