package com.example.obspringsecurityoauthgithub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/login**").permitAll() // Permitir acceso sin autenticación a las rutas "/", "/login", y cualquier subruta de "/login"
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/oauth2/authorization/github") // Personalizar la página de inicio de sesión OAuth2
                );

        return http.build();
    }
}
