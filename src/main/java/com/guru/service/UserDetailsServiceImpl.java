package com.guru.service;

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

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
import com.guru.repository.RoleEntityRepository;
import com.guru.repository.UserEntityRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserEntityRepository userEntityRepository;
    
    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.findByUsername(username);
        List<RoleEntity> roles = roleEntityRepository.findAll();
       

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (RoleEntity role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
