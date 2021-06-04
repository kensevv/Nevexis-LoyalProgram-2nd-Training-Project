package com.nevexis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nevexis.security.MyTokenService;
import com.nevexis.security.UserDetailsServiceImpl;

public class ServiceHolder {
	@Autowired
	protected BCryptPasswordEncoder passEncoder;
	@Autowired
	protected MyTokenService tokenService;
	@Autowired
	protected UserDetailsServiceImpl userDetailsService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected SalesService salesService;
	@Autowired
	protected RoleService rolesService;
}
