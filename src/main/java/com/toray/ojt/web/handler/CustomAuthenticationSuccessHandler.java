package com.toray.ojt.web.handler;

import com.toray.ojt.web.dto.UserUpdateDto;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserMapper userMapper;

    public CustomAuthenticationSuccessHandler(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = request.getParameter("username");
        User user = userMapper.findByAccountId(username);

        if (user != null) {
            // Reset failed login attempts on successful login
            UserUpdateDto userUpdateDto = new UserUpdateDto();
            userUpdateDto.setAccountId(user.getAccountId());
            userUpdateDto.setState(user.getState()); // Keep the same state
            userUpdateDto.setFailedLoginAttempts(0); // Reset to 0

            // Update user information
            userMapper.updateFailedLoginAttempt(userUpdateDto);
        }

        // Determine the target URL based on the user's roles
        String targetUrl = determineTargetUrl(authentication);

        // Redirect to the target URL
        response.sendRedirect(targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        boolean baseAdmin = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("base_admin"));
        boolean regularUser = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("regular_user"));

        // Print authorities for debugging
        authentication.getAuthorities().forEach(authority ->
                System.out.println("Authority: " + authority.getAuthority())
        );

        // Determine the target URL based on the user's role
        if (baseAdmin) {
            return "/toppage"; // URL for base admin
        } else if (regularUser) {
            return "/loginsuccess"; // URL for regular user
        } else {
            System.err.println("No valid role found for user: " + authentication.getName());
            return "/?error=true";
        }
    }
}
