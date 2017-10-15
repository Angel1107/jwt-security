package com.angel1107.account.config;

import org.springframework.stereotype.Component;

import com.angel1107.account.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtValidator {
	 private String secret = "angel1107";
	 
	 public JwtUser validate(String token) {
		  JwtUser jwtUser = null;
		  Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		  jwtUser = new JwtUser();
          jwtUser.setUserName(body.getSubject());
          jwtUser.setId(Long.parseLong((String) body.get("userId")));
          jwtUser.setRole((String) body.get("role"));
		  return jwtUser;
	 }
	 
	 
	 public String generate(JwtUser jwtUser) {
	        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
	        claims.put("userId", String.valueOf(jwtUser.getId()));
	        claims.put("role", jwtUser.getRole());
	        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	    }

}
