package com.guru.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
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
		model.addAttribute("userEntity", new UserEntity());
		model.addAttribute("roles", roleEntityManager.getAll());
		model.addAttribute("userEntities", userEntityManager.findAll());
		return "manageUserPage";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editUser(@RequestParam("username") String username, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("userEntities", userEntityManager.findAll());
		UserEntity user = userEntityManager.getByUsername(username);
		model.addAttribute("roles", roleEntityManager.getAll());
		model.addAttribute("userEntity", user);
		return "manageUserPage";
	}
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("username") String username, Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		UserEntity user = userEntityManager.getByUsername(username);
		userEntityManager.deleteUserEntity(user);
		return "redirect:user";
	}

	@Transactional
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid UserEntity userEntity, BindingResult bindingResult, HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		System.out.println(role);
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "redirect:user";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		UserEntity user = userEntityManager.getByUsername(username);
		System.out.println(user.getId());
		RoleEntity roleEntity = roleEntityManager.getByName(role);
		user.setAddress(address);
		user.setCreated(Calendar.getInstance().getTime());
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
		roleEntities.add(roleEntity);
		user.setRoles(roleEntities);
		userEntityManager.saveUserEntity(user);
		return "redirect:user";
	}

	@Transactional
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Valid UserEntity userEntity, BindingResult bindingResult, HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String role = request.getParameter("role");
		System.out.println(role);
		if (bindingResult.hasErrors()) {
			// handle error
			logger.error("===Got error");
			return "redirect:user";
		} else {
			logger.info("=== No error");
			// insert into database
		}
		UserEntity userEntityAdd = new UserEntity(username, address, Calendar.getInstance().getTime(), email, password,
				phone);
		userEntityManager.saveUserEntity(userEntityAdd);
		RoleEntity roleEntity = roleEntityManager.getByName(role);
		userRoleEntityManager.saveUserRole(roleEntity.getId(),userEntityAdd.getId());
		return "redirect:user";
	}
}
