package com.library.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests
          //.requestMatchers("/api/libros/**").hasRole("USER") dado que no se configuro un mecanismo de autenticación se comenta la opcion de rol
          //.requestMatchers("/api/libros/**").denyAll() de momento los vamos a permitir todos
            .requestMatchers("/api/libros/**").permitAll()
            .requestMatchers("/swagger-ui/**","/v3/**").permitAll()
            .requestMatchers("/api/login").permitAll() 
    );
              
        return http.build();
    }
}