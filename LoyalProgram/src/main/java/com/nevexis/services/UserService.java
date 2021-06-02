package com.nevexis.services;

import org.springframework.stereotype.Service;

import com.nevexis.models.User;

@Service
public class UserService extends BasicService {
	private static final String getUserByUsername = "User.getUserByUsername";

	public User getUserByUsername(String username) {
		return em.createNamedQuery(getUserByUsername, User.class).setParameter("username", username).getSingleResult();
	}
}
