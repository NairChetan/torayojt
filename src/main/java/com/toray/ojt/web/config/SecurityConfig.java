package com.toray.ojt.web.config;

import com.toray.ojt.web.handler.CustomAuthenticationFailiureHandler;
import com.toray.ojt.web.handler.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration

public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailiureHandler failureHandler;

    public SecurityConfig(UserDetailsService userDetailsService,
                          CustomAuthenticationSuccessHandler successHandler,
                          CustomAuthenticationFailiureHandler failureHandler) {
        this.userDetailsService = userDetailsService;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/**") // Adjust as needed for security
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/css/**", "/images/**").permitAll() // Allow access to the login page at the root URL
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/") // Custom login page at the root URL
                        .loginProcessingUrl("/login") // Define the login processing URL
                        .permitAll() // Allow all users to access the login page
                        .successHandler(successHandler) // Use the custom success handler
                        .failureHandler(failureHandler) // Use the custom failure handler
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // Allow logout with a GET request
                        .logoutSuccessUrl("/?logout=true") // Redirect after logout
                        .invalidateHttpSession(true) // Invalidate the session on logout
                        .permitAll() // Allow all users to access logout
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password hashing
    }
}