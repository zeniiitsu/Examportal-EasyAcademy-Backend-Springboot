/**
 * 
 */
package com.exam.examportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.examportal.service.impl.UserDetailsServiceImpl;

/**
 * @author Bhavesh
 *
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled=true)
public class MySecurityConfig{
	
	
	  @Autowired
	  UserDetailsServiceImpl userDetailsServiceImpl;

	  @Autowired
	  JwtAuthenticationEntryPoint unauthorizedHandler;
	  
	  @Autowired
	  JwtAuthenticationFilter jwtAuthenticationFilter;
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder(){
		  return new BCryptPasswordEncoder();
	  }
	  
	  
//	  @Bean
//	  public PasswordEncoder passwordEncoder(){
//		  return new TestPasswordEnconder();
//		  //for testing purpose we use TestPassWordEncoder
//	  }
	  
	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

	@Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsServiceImpl);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	
	 @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf()
	    .disable()
	    .cors()
	    .disable()
	    .authorizeRequests()
	    .requestMatchers("/generate-token","/user/")
	    .permitAll()
	    .requestMatchers(HttpMethod.OPTIONS)
	    .permitAll()
	    .anyRequest()
	    .authenticated()
	    .and()
	    .exceptionHandling()
	    .authenticationEntryPoint(unauthorizedHandler)
	    .and()
	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	    
	    // http....;
	    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    return http.build();
	    
	    
	  }
	 
	 
	 
	
	
}
