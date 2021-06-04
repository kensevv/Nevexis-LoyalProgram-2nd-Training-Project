package com.nevexis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nevexis.models.User;
import com.nevexis.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override 
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		return UserDetailsImpl.build(user);
	}
}