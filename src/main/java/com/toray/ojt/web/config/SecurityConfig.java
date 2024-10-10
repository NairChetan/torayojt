package com.toray.ojt.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**") // Disable CSRF for specific paths like APIs
                )
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()  // Allow access to the login page at the root URL
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin((form) -> form
                        .loginPage("/")  // Custom login page at the root URL
                        .permitAll()  // Allow all users to access the login page
//                        .defaultSuccessUrl("/loginsuccess", true)  // Redirect on successful login
                        .failureUrl("/?error=true")  // Redirect to login with error on failure
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/?logout=true")  // Redirect after logout
                        .permitAll()  // Allow all users to access logout
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password hashing
    }
}

