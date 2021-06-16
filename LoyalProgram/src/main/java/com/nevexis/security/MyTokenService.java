package com.nevexis.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
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
	private static final String SPLITTER = "&@";
	private static final long EXPIRATION_MS = 3_600_000l;
	private static final SecureRandom random = new SecureRandom();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public String generateToken(String username) {
		Date expirationDate = new Date((new Date()).getTime() + EXPIRATION_MS);

		StringBuffer buffer = new StringBuffer(50);
		buffer.append(SECURE_KEY).append(SPLITTER).append(username).append(SPLITTER)
				.append(formatter.format(expirationDate)).append(SPLITTER).append(random.nextLong());

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
		UserAuthToken dbAuth = em.find(UserAuthToken.class, encryptToken(token));
		return dbAuth != null;
	}

	private void setTokenExpired(String token) {
		UserAuthToken auth = em.find(UserAuthToken.class, encryptToken(token));
		if (null != auth) {
			auth.setStatus(AuthStatus.EXPIRED);
		}
	}

	public String extractUsernameFromToken(String token) {
		return token.split(SPLITTER)[1];
	}

	public Date extractExpirationDate(String token) throws ParseException {
		return formatter.parse(token.split(SPLITTER)[2]);
	}

	public Long extractSecureKey(String token) {
		return Long.parseLong(token.split(SPLITTER)[3]);
	}

	public String encryptToken(String token) {
		try {
			return Base64.getEncoder()
					.encodeToString(MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			throw new Error("NO SUCH ALGORITHM SHA-256");
		}
	}
	
	public boolean compareTokens(String token, String encodedToken) throws NoSuchAlgorithmException {
		return encryptToken(token).equals(encodedToken);
	}

	public void persistToken(String token) throws ParseException {
		UserAuthToken userAuthToken = new UserAuthToken(encryptToken(token),
				userService.getUserByUsername(extractUsernameFromToken(token)), extractExpirationDate(token), new Date(), AuthStatus.VALID);
		em.persist(userAuthToken);
	}
}
