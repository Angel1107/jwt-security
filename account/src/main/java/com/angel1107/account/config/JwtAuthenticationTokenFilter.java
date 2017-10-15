package com.angel1107.account.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
	 public JwtAuthenticationTokenFilter() {
	      // super("/openregist/**");
		 super("/rest/**");
	    }

	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

	        String header = httpServletRequest.getHeader("Authorisation");


	        if (header == null || !header.startsWith("Token:")) {
	            throw new RuntimeException("JWT Token is missing->jwt Token丢失");
	        }
	        String authenticationToken = header.substring(6);
	        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
	        return getAuthenticationManager().authenticate(token);
	    }


	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        super.successfulAuthentication(request, response, chain, authResult);
	        chain.doFilter(request, response);
	    }

}