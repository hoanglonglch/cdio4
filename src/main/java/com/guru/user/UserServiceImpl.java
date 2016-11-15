package com.guru.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
import com.guru.service.RoleEntityManager;
import com.guru.service.UserEntityManager;

public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserEntityManager userEntityManager;
	
	@Autowired
	private RoleEntityManager roleEntityManager;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userEntityManager.getByUsername("toan");
		ModelMap model = new ModelMap();
		model.addAttribute("user",user);
		List<RoleEntity> roles = roleEntityManager.getAll();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (RoleEntity role : roles ) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}
