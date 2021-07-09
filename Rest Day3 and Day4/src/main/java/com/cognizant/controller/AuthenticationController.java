package com.cognizant.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	@GetMapping("/authenticate")
	public Map<String, String> authentication(@RequestHeader("Authorization") String authHeader) {

		Map<String, String> m = new HashMap<String, String>();
		m.put("Token", "");

		return m;

	}

	private String getUser(String authHeader) {
		String originalInput = "Basic";
		byte[] encodedString = Base64.encode(originalInput.getBytes());
		byte[] valueDecoded = Base64.decode(encodedString);
		String user = Arrays.toString(valueDecoded);

		return user;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();

		builder.setSubject(user);

		builder.setIssuedAt(new Date());

		builder.setExpiration(new Date((new Date()).getTime() + 1200000));

		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		return token;
	}

}
