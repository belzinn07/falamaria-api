package com.falamaria.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // 1. Desabilita o CSRF (Cross-Site Request Forgery). 
            // Em APIs REST, geralmente desabilitamos porque não usamos "sessions" de navegador.
            .csrf(csrf -> csrf.disable()) 
            
            // 2. Define que a API é Stateless (não guarda estado).
            // O servidor não vai criar uma "sessão" para o usuário. Cada requisição é única.
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // 3. Regras de autorização
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // Por enquanto, libera todas as rotas para você testar no Postman
                  
            )
            .build();
    }
}