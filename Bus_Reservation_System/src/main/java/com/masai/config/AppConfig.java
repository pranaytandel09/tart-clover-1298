package com.masai.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;



@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			
		.cors(cors ->{
			cors.configurationSource(new CorsConfigurationSource() {
				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration configuration= new CorsConfiguration();
					configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
					configuration.setAllowedMethods(Collections.singletonList("*"));
					configuration.setAllowCredentials(true);
					configuration.setAllowedHeaders(Collections.singletonList("*"));
					configuration.setExposedHeaders(Arrays.asList("Authorization"));
					return configuration;
				}
			});
		})
		.authorizeHttpRequests(auth ->{
			auth
			.requestMatchers("/user/logIn","/user/users_signIn","admin/get_buses_by_busId/{busId}","admin/get_buses_by_type/{busType}",
					"admin/get_buses","admin/get_routes","admin/get_routes_by_routeId/{routeId}","/swagger-ui*/**","/v3/api-docs/**").permitAll()
			
			.requestMatchers("user/update_users","user/delete_users/{userId}","user/users/add_reservations/{userId}/{busId}","user/users/update_reservations",
					"user/users/delete_reservations/{reservationId}","user/users/add_feedbacks/{userId}/{busId}","user/users/update_feedbacks").hasRole("USER")
			
			.requestMatchers("admin/add_buses/{routeId}","admin/update_buses","admin/delete_buses/{busId}","admin/add_routes","admin/update_routes","admin/delete_routes/{routeId}",
					"user/get_users","user/users/get_reservations_by_date/{date}").hasRole("ADMIN")
			
			.requestMatchers("user/get_users/{userId}","user/users/get_reservations_by_reservationId/{reservationId}","user/users/get_reservations_by_userId/{userId}"
					,"user/users/get_feedbacks_by_feedbackId/{feedbackId}","user/users/get_feedbacks_by_userId/{userId}").hasAnyRole("USER","ADMIN")
			.anyRequest().authenticated();
			
			//.anyRequest().permitAll();
				
				})
			.csrf(csrf -> csrf.disable())
			.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
			.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
