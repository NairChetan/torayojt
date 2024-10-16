package com.toray.ojt.web.handler;

import com.toray.ojt.web.dto.UserUpdateDto;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.context.i18n.LocaleContextHolder;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

@Component
public class CustomAuthenticationFailiureHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationFailiureHandler.class);
    private final UserMapper userMapper;
    private final MessageSource messageSource;

    public CustomAuthenticationFailiureHandler(UserMapper userMapper,MessageSource messageSource) {
        this.userMapper = userMapper;
        this.messageSource = messageSource;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        String errorMessage = exception.getMessage();
        String langParam = request.getParameter("lang");  // Retrieve the lang parameter
        log.debug("language parameter: {}",langParam);
        Locale locale = LocaleContextHolder.getLocale();
        if (errorMessage.contains("Bad credentials")) {
            errorMessage = messageSource.getMessage("auth.error.bad_credentials", null, locale);
        }
        User user = userMapper.findByAccountId(username);

        if (user != null) {
            // Safely handle null values for failedLoginAttempts
            UserUpdateDto userUpdateDto = getUserUpdateDto(user);

            // Update failed login attempts in the database
            userMapper.updateFailedLoginAttempt(userUpdateDto);
        }

        // Redirect back to the login page with an error parameter
        response.sendRedirect("/?error=" + URLEncoder.encode(errorMessage, "UTF-8") + "&lang=" + langParam);
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
