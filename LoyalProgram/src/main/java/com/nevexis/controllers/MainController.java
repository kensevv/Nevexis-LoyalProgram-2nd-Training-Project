package com.nevexis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MainController {
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String hello() {
		return "HELLO ADMIN!";
	}
	
	@GetMapping("/owner")
	@PreAuthorize("hasRole('OWNER')")
	public String helloOwner() {
		return "HELLO OWNER!";
	}
}
