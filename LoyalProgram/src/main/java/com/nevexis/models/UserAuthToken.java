package com.nevexis.models;

import java.util.Date;

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
	private Date expirationDate;
	private Date issuedDate;
	@Enumerated(EnumType.STRING)
	private AuthStatus status;
	
	public UserAuthToken() {}
	
	
	public UserAuthToken(String encryptedToken, User user, Date expirationDate, Date issuedDate, AuthStatus status) {
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


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public Date getIssuedDate() {
		return issuedDate;
	}


	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
}
