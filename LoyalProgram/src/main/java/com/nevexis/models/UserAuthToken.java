package com.nevexis.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "user_auth_token")
public class UserAuthToken {
	@Id
	private String encryptedToken;
	@OneToOne
	private User user;
	private LocalDateTime expirationDate;
	private LocalDateTime issuedDate;
	@Enumerated(EnumType.STRING)
	private AuthStatus status;
	
	public UserAuthToken() {}
	
	
	public UserAuthToken(String encryptedToken, User user, LocalDateTime expirationDate, LocalDateTime issuedDate, AuthStatus status) {
		this.encryptedToken = encryptedToken;
		this.user = user;
		this.expirationDate = expirationDate;
		this.issuedDate = issuedDate;
		this.status = status;
	}


	public String getTokenHash() {
		return encryptedToken;
	}

	public void setTokenHash(String encryptedToken) {
		this.encryptedToken = encryptedToken;
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


	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}


	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}


	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}
}
