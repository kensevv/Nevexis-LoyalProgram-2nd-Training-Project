package com.nevexis.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nevexis.models.User;
import com.nevexis.security.UserDetailsImpl;

@Service
@Transactional
public class UserService extends BasicService {
	private static final String getUserByUsername = "User.getUserByUsername";

	public User getUserByUsername(String username) {
		return em.createNamedQuery(getUserByUsername, User.class).setParameter("username", username).getSingleResult();
	}

	public void incrementFailedAttempts(UserDetailsImpl userDetails) {
		String username = userDetails.getUsername();
		getUserByUsername(username).setFailedAttempts(getUserByUsername(username).getFailedAttempts() + 1);
	}

	public void resetFailedAttempts(UserDetailsImpl userDetails) {
		getUserByUsername(userDetails.getUsername()).setFailedAttempts(0);
	}

	public void disableUserIfLimitReached(UserDetailsImpl userDetails) {
		User dbUser = getUserByUsername(userDetails.getUsername());
		if (dbUser.getFailedAttempts() == 3) {
			dbUser.setEnabled(false);
		}
	}

	public boolean accountIsEnabled(UserDetailsImpl userDetails) {
		return getUserByUsername(userDetails.getUsername()).getEnabled();
	}
}