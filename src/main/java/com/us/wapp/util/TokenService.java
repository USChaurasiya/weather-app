package com.us.wapp.util;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static com.us.wapp.util.AppConstant.SECRET;
import static com.us.wapp.util.AppConstant.EXPIRATION_TIME;
/**
 * Helper class to generate the Token by taking the user data.
 * @author UmaShankar
 * @since 14-Feb-2019
 *
 */
@Service
public class TokenService {

	/**
	 * Generate Access Token for Particular User by taking user info.
	 * @param data
	 * @return String
	 */
	public String generateToken(String data) {
		String token = Jwts.builder()
			.setSubject(data)
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		return token;
	}
}
