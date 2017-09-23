package com.dhm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.dhm.filter.CorsFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	CorsFilter corsFilter(){
		return new CorsFilter() ; 
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/api/**") ; 
				
	}
	 @Override
     protected void configure(HttpSecurity http) throws Exception {
         // disable caching
         http
         .addFilterBefore(corsFilter(), ChannelProcessingFilter.class)
         .headers().cacheControl();

         http.csrf().disable() // disable csrf for our requests.
             .authorizeRequests()
             .antMatchers(HttpMethod.GET, "/login/**").permitAll()
             .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
             .anyRequest().authenticated()
             .and()
             
			// enabling the basic authentication
			.httpBasic().and()
			// configuring the session as state less. Which means there is
			// no session in the server
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			// disabling the CSRF - Cross Site Request Forgery
			.csrf().disable();
	 	}
}
