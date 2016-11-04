package com.guru.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.guru.entities.UserEntity;
import com.guru.entities.UserRoleEntity;
import com.guru.repository.UserEntityRepository;

public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userEntityRepository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (UserRoleEntity role : user.getUserRoles() ) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleBean().getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}
