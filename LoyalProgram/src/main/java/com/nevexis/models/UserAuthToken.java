package com.nevexis.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "user_auth_token")
public class UserAuthToken {
	@Id
	private Integer tokenHash;
	@OneToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private AuthStatus status;
	
	public UserAuthToken() {}
	
	public UserAuthToken(Integer tokenHash, User user, AuthStatus status) {
		this.tokenHash = tokenHash;
		this.user = user;
		this.status = status;
	}

	public Integer getTokenHash() {
		return tokenHash;
	}

	public void setTokenHash(Integer tokenHash) {
		this.tokenHash = tokenHash;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuthStatus getStatus() {
		return status;
	}

	public void setStatus(AuthStatus status) {
		this.status = status;
	}
}
