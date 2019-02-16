package com.us.wapp.util;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static com.us.wapp.util.AppConstant.SECRET;
import static com.us.wapp.util.AppConstant.EXPIRATION_TIME;
@Service
public class TokenService {

	public String generateToken(String data) {
		String token = Jwts.builder()
			.setSubject(data)
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		return token;
	}
}
