package com.masai;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
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
				.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll();
				})
			.csrf(csrf -> csrf.disable())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
