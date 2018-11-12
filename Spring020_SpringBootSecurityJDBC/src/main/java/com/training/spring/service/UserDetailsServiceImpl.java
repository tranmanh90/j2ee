package com.training.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.spring.dao.AppRoleDAO;
import com.training.spring.dao.AppUserDAO;
import com.training.spring.model.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserDAO appUserDAO;

	@Autowired
	private AppRoleDAO appRoleDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = this.appUserDAO.findUserAccount(username);
		if (appUser == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		// [ROLE_USER, ROLE_ADMIN,..]
		List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		if (roleNames != null) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantedAuthorities.add(authority);
			}
		}

		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncrytedPassword(),
				grantedAuthorities);
		return userDetails;
	}
}
