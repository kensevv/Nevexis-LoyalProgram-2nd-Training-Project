package com.nevexis.services;

import org.springframework.stereotype.Service;

import com.nevexis.models.User;

@Service
public class UserService extends BasicService {
	private static final String getUserByUsername = "User.getUserByUsername";

	public User getUserByUsername(String username) {
		return em.createNamedQuery(getUserByUsername, User.class).setParameter("username", username).getSingleResult();
	}
	
	public void incrementFailedAttempts(String username) {
		User dbUser = getUserByUsername(username);
		dbUser.setFailedAttempts(dbUser.getFailedAttempts() + 1);
	}
	
	public void resetFailedAttempts(String username) {
		getUserByUsername(username).setFailedAttempts(0);
	}
	
	public void registerUser(User user) {
		
	}
}