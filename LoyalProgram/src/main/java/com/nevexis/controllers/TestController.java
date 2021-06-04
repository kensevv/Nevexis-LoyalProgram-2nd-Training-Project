package com.nevexis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.security.UserDetailsImpl;

@RestController
@RequestMapping("/hello")
public class TestController {
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String helloAdmin() {
		
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("HELLO ADMIN\n").append(userDetails.getUsername() + "\n").append(userDetails.getEmail() + "\n")
				.append(userDetails.getPassword() + "\n").append(userDetails.getAuthorities().toString());
		return buffer.toString();
	}

	@GetMapping("/owner")
	@PreAuthorize("hasRole('OWNER')")
	public String helloOwner() {
		return "HELLO OWNER!";
	}
}
