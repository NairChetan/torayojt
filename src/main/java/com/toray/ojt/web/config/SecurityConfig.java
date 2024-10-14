package com.toray.ojt.web.config;

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
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/**")
                )
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/","/css/**","/images/**").permitAll()  // Allow access to the login page at the root URL
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin((form) -> form
                        .loginPage("/")  // Custom login page at the root URL
                        .loginProcessingUrl("/login") // Define the login processing URL
                        .permitAll()  // Allow all users to access the login page
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect(determineTargetUrl(authentication));
                        })
                        .failureUrl("/?error=true")  // Redirect to login with error on failure
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) //allows logout with a GET request
                        .logoutSuccessUrl("/?logout=true")  // Redirect after logout
                        .invalidateHttpSession(true)
                        .permitAll()  // Allow all users to access logout
                );

        return http.build();
    }

    private String determineTargetUrl(Authentication authentication) {
        boolean baseAdmin = authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("base_admin"));
        boolean regularUser = authentication.getAuthorities().stream().anyMatch(role-> role.getAuthority().equals("regular_user"));
        authentication.getAuthorities().forEach(authority ->
                System.out.println("Authority: " + authority.getAuthority())
        );

        if(baseAdmin){
            return "/toppage";
        } else if (regularUser) {
            return "/loginsuccess";
        }
        else{
            return "/toppage";
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password hashing
    }
}