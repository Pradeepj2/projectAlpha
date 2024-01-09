package com.Alpha.Alpha.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.Alpha.Alpha.Service.CustomSuccessHandler;



@Configuration
public class SecurityConfig {
	

	@Autowired
	private CustomSuccessHandler cuHandler;
	
	
	@Autowired
	private customUserDetails customUserDetails;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user =  User.withUsername("pradeepu")
//		        .password(passwordEncoder().encode("12345"))
//		        .roles("User")
//		        .build();
//		UserDetails admin =  User.withUsername("pradeepa")
//				.password(passwordEncoder().encode("12345"))
//				.roles("Admin")
//				.build();
//		return new InMemoryUserDetailsManager(user , admin);
//		
//		return new customUserDetails();
//	}
//	
	
	@Bean
	AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(this.customUserDetails);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable())
				.authorizeHttpRequests(
						request -> request
						        .requestMatchers("/admin/**").hasAuthority("Admin")
						        .requestMatchers("/user/**").hasAuthority("User")
								.requestMatchers("/registration").permitAll()
								.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").successHandler(cuHandler)
						.permitAll());
		
		http.authenticationProvider(daoAuthenticationProvider());
		
		return http.build();
	}

}
