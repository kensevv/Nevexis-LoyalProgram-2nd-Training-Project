package com.nevexis.security;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nevexis.models.AuthStatus;
import com.nevexis.models.UserAuthToken;
import com.nevexis.services.BasicService;
import com.nevexis.services.UserService;

@Service
public class MyTokenService extends BasicService {
	@Autowired
	private UserService userService;

	private static final String SECURE_KEY = "KenanSecurity";
	private static final long EXPIRATION_MS = 3_600_000l;
	private static final SecureRandom random = new SecureRandom();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public String generateToken(String username) {
		Date expirationDate = new Date((new Date()).getTime() + EXPIRATION_MS);

		StringBuffer buffer = new StringBuffer();
		buffer.append(SECURE_KEY).append("&").append(username).append("&").append(formatter.format(expirationDate))
				.append("&").append(random.nextLong());

		return buffer.toString();
	}

	public boolean validateToken(String token) throws ParseException {
		if (StringUtils.hasText(token) && token.startsWith(SECURE_KEY)) {
			if (extractExpirationDate(token).after(new Date()) && tokenExistsInDb(token)) {
				return true;
			} else {
				setTokenExpired(token);
			}
		}
		return false;
	}
	
	private boolean tokenExistsInDb(String token) {
		UserAuthToken dbAuth = em.find(UserAuthToken.class, hashToken(token));
		return dbAuth != null;
	}
	private void setTokenExpired(String token) {
		UserAuthToken auth = em.find(UserAuthToken.class, hashToken(token));
		if (null != auth) {
			auth.setStatus(AuthStatus.EXPIRED);
		}
	}

	public String extractUsernameFromToken(String token) {
		if (null == token) {
			return null;
		}
		return token.split("&")[1];
	}

	public Date extractExpirationDate(String token) throws ParseException {
		if (null == token) {
			return null;
		}
		return formatter.parse(token.split("&")[2]);
	}

	public Long extractSecureKey(String token) {
		if (null == token) {
			return null;
		}
		return Long.parseLong(token.split("&")[3]);
	}

	public int hashToken(String token) {
		return token.hashCode();
	}

	public void persistToken(String token) {
		UserAuthToken authentication = new UserAuthToken(hashToken(token),
				userService.getUserByUsername(extractUsernameFromToken(token)), AuthStatus.VALID);
		em.persist(authentication);
	}
}
