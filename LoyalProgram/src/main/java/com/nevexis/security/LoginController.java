package com.nevexis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.services.UserService;

@RestController
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	@Autowired
	private MyTokenService tokenService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
		String myToken = new String();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		if (null != userDetails) {
			if (passEncoder.matches(password, userDetails.getPassword())) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				myToken = tokenService.generateToken(username);
				tokenService.persistToken(myToken);
			} else {
				userService.incrementFailedAttempts(userDetails.getUsername());
			}
		}
		return ResponseEntity.ok(myToken);
	}
}