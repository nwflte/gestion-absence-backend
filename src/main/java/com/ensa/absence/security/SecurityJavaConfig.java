package com.ensa.absence.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//@Configuration
//@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception 
	    {
		 	//http.addFilterBefore(corsFilter(), ChannelProcessingFilter.class);
		 	
	        http
            .csrf()
            	.disable()
            .cors()
            	.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
            	.and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            	.and()
	        .authorizeRequests().anyRequest().permitAll()
	        	.and()
	        .httpBasic();
	    }
	  
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	            throws Exception 
	    {
	        auth.inMemoryAuthentication()
	            .withUser("admin")
	            .password("{noop}password")
	            .roles("USER");
	    }
	    
	    @Bean
		CorsConfigurationSource corsConfigurationSource() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			
			config.setAllowedOrigins(Arrays.asList("*"));
			config.setAllowedMethods(Arrays.asList("*"));
			config.setAllowedHeaders(Arrays.asList("*"));
			config.setAllowCredentials(true);
			config.applyPermitDefaultValues();
			source.registerCorsConfiguration("/**", config);
			return source;
		}
			
	    /*
		  @Bean
		  protected Filter corsFilter()
		  {
		    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		    CorsConfiguration config = new CorsConfiguration();
		    config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("OPTIONS");
		    config.addAllowedMethod("HEAD");
		    config.addAllowedMethod("GET");
		    config.addAllowedMethod("PUT");
		    config.addAllowedMethod("POST");
		    config.addAllowedMethod("DELETE");
		    config.addAllowedMethod("PATCH");
		    config.addExposedHeader("Location");

		    source.registerCorsConfiguration("/**", config);

		    return new CorsFilter(source);
		  }*/
}