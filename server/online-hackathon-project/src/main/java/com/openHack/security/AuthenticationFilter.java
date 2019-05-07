package com.openHack.security;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openHack.SpringApplicationContext;
import com.openHack.service.UserService;
import com.openHack.shared.dto.UserDto;
import com.openHack.ui.model.request.UserLoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.json.Json;
import javax.json.JsonObject;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		try{
			UserLoginRequestModel credentials = new ObjectMapper()
					.readValue(request.getInputStream(), UserLoginRequestModel.class);
			
			// credential check
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword(), new ArrayList<>()));
		}catch ( IOException e) {
			throw new RuntimeException(e);
		}
	}

	// if user is authenticated then only above method is called
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		
		String email = ( (User) authResult.getPrincipal()).getUsername();
		
		// JWT token creation
		String token = Jwts.builder()
						.setSubject(email)
						.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_DATE))
						.signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
						.compact();
		
		// fetching email id for sending in a response
		UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
		UserDto userDto = userService.getUser(email);
		
		boolean isEmailVerified = userDto.isEmailVerfied();
		JsonObject object;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if (!isEmailVerified)
		{
			object = Json.createObjectBuilder().add("Message", "false").build();
			response.setStatus(400);
		}
		else
		{
			String user = userDto.getEmail();
			boolean role = userDto.isAdminCheck();
		
			// setting token and email after successful LOGIN
			System.out.println(" response " + response);
	    
			object = Json.createObjectBuilder().add("token", token)
	    									   .add("user", user)
	    									   .add("admin", role).build();
		}
	    response.getWriter().write(object.toString());
	}	
}
