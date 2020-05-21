package com.sarabadu.blog.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
			// -- swagger ui
			"/v2/api-docs", "/swagger-resources", "/swagger-resources/**", 
			"/configuration/ui", "/configuration/security",
			"/swagger-ui.html", "/webjars/**"
			// if you need to leave any other endpoint without auth you can add it here.
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers("/**").permitAll(); // for now we leave without security all our endpoints
	}

}
