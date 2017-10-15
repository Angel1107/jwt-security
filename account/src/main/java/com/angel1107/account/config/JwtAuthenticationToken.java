package com.angel1107.account.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7044156785120740301L;
		private String token;

	    public JwtAuthenticationToken(String token) {
	        super(null, null);
	        this.token = token;
	    }
	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

}
