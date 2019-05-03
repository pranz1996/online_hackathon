package com.openHack.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.openHack.service.UserService;
import com.openHack.security.SecurityConstants;

@EnableWebSecurity
public class EntryPointOfApplication extends WebSecurityConfigurerAdapter{
	
	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public EntryPointOfApplication(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)		// Allow Sign_up request without any Authorization
		.permitAll()
		.anyRequest().authenticated().and()
		.addFilter(new AuthenticationFilter(authenticationManager()))			// Authentication filter configuration
		.addFilter(new AuthorizationFilter(authenticationManager()))			// Authorization filter configuration
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);				// required authentication for every request
	}
	
	// Spring Security functionalities of BCrypt 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
}
