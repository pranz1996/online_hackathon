package com.openHack.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	// authorization for every request made 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String header = request.getHeader(SecurityConstants.HEADER_STRING);
		
		// if no token in header
		if(header == null) {
			chain.doFilter(request, response);
			return;
		}
		
		// if token in header then using getAuthentication() method to verify token
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		
		System.out.println(" Login 7 ... ");
		
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if(token != null) {
			
			// parsing the token to verify the authenticity
			String user = Jwts.parser()
					.setSigningKey( SecurityConstants.TOKEN_SECRET )
					.parseClaimsJws(token)
					.getBody()	
					.getSubject();

			// on a successful authorization, the called API request is allowed
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			
			return null;
		}
		
		return null;
	}
	
	
}

