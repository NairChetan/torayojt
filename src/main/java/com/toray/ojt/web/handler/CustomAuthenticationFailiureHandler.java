package com.toray.ojt.web.handler;

import com.toray.ojt.web.dto.UserUpdateDto;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomAuthenticationFailiureHandler implements AuthenticationFailureHandler {
    private final UserMapper userMapper;

    public CustomAuthenticationFailiureHandler(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        String errorMessage = exception.getMessage();
        if(errorMessage.contains("Bad credentials")){
            errorMessage = "Invalid username or password";
        }
        User user = userMapper.findByAccountId(username);

        if (user != null) {
            // Safely handle null values for failedLoginAttempts
            UserUpdateDto userUpdateDto = getUserUpdateDto(user);

            // Update failed login attempts in the database
            userMapper.updateFailedLoginAttempt(userUpdateDto);
        }

        // Redirect back to the login page with an error parameter
        response.sendRedirect("/?error=" + URLEncoder.encode(errorMessage, "UTF-8"));
    }

    private static UserUpdateDto getUserUpdateDto(User user) {
        int failedAttempts = (user.getFailedLoginAttempts() != null) ? user.getFailedLoginAttempts() : 0;
        failedAttempts++;  // Increment the failed login attempts

        // Create a DTO for updating
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setAccountId(user.getAccountId()); // Make sure your DTO includes this
        userUpdateDto.setState(user.getState()); // Assuming you want to keep the same state
        userUpdateDto.setFailedLoginAttempts(failedAttempts);
        return userUpdateDto;
    }
}
