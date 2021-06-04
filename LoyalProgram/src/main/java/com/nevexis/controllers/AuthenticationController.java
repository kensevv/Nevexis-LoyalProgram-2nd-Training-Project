package com.nevexis.controllers;

import java.text.ParseException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.payload.LoginRequest;
import com.nevexis.security.UserDetailsImpl;
import com.nevexis.services.ServiceHolder;

@RestController
public class AuthenticationController extends ServiceHolder {
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
			throws ParseException {
		String myToken = new String();

		UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (null != userDetails) {
			if (passEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
				userService.resetFailedAttempts(loginRequest.getUsername());

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				myToken = tokenService.generateToken(loginRequest.getUsername());
				tokenService.persistToken(myToken);
			} else {
				userService.incrementFailedAttempts(userDetails.getUsername());
			}
		}
		HttpHeaders authorizationHeader = new HttpHeaders();
		authorizationHeader.set("Authorization", myToken);
		return new ResponseEntity<>(authorizationHeader, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/register") public ResponseEntity<?> register(@RequestParam
	 * String email, @RequestParam String username,
	 * 
	 * @RequestParam String password) {
	 * 
	 * }
	 */

}