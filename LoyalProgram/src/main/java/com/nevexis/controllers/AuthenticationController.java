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

		if (null != userDetails && userService.accountIsEnabled(userDetails)) {
			if (passEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
				userService.resetFailedAttempts(userDetails);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				myToken = tokenService.generateToken(loginRequest.getUsername());
				tokenService.persistToken(myToken);
				
				HttpHeaders authorizationHeader = new HttpHeaders();
				authorizationHeader.set("Authorization", myToken);
				return new ResponseEntity<>(authorizationHeader, HttpStatus.OK);
			} else {
				userService.incrementFailedAttempts(userDetails);
				userService.disableUserIfLimitReached(userDetails);
				return new ResponseEntity<>("Wrong credentials", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("Account DISABLED", HttpStatus.BAD_REQUEST);
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