package com.guru.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
import com.guru.entities.UserRoleEntity;
import com.guru.service.RoleEntityManager;
import com.guru.service.UserEntityManager;
import com.guru.service.UserRoleEntityManager;

@Controller
@RequestMapping(value = "/admin")
public class ManageUserController {
	private static final Logger logger = LoggerFactory.getLogger(ManageUserController.class);
	@Autowired
	UserEntityManager userEntityManager;
	
	@Autowired
	RoleEntityManager roleEntityManager;
	
	@Autowired
	UserRoleEntityManager userRoleEntityManager;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("userEntities",userEntityManager.findAll());
		return "manageUserPage";
	}
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String register(@Valid UserEntity userEntity,
			BindingResult bindingResult, HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String role = request.getParameter("role");
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "loginPage";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		UserEntity userEntityAdd = new UserEntity(username, address, Calendar.getInstance().getTime(),
				email, password, phone);
		userEntityManager.saveUserEntity(userEntityAdd);
		RoleEntity roleEntity = roleEntityManager.getByName(role);
		UserRoleEntity userRoleEntity = new UserRoleEntity(roleEntity, userEntityAdd);
		userRoleEntityManager.saveUserRole(userRoleEntity);
		return "manageUserPage";
	}
}
