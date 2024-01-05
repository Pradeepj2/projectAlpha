package com.Alpha.Alpha.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user =  User.withUsername("pradeepu")
		        .password(passwordEncoder().encode("12345"))
		        .roles("User")
		        .build();
		UserDetails admin =  User.withUsername("pradeepa")
				.password(passwordEncoder().encode("12345"))
				.roles("Admin")
				.build();
		
		return new InMemoryUserDetailsManager(user , admin);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(c -> c.disable())
				.authorizeHttpRequests(
						request -> request
						        .requestMatchers("/admin/**").hasRole("Admin")
						        .requestMatchers("/user/**").hasRole("User")
								.requestMatchers("/registration").permitAll()
								.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").successHandler(cuHandler)
						.permitAll());
		return http.build();
	}

}
