package com.toray.ojt.web.controller;

import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.entity.UserDetails;
import com.toray.ojt.web.service.BaseAttributeService;
import com.toray.ojt.web.service.UserDetailsService;
import com.toray.ojt.web.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Import HttpSession
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final BaseAttributeService baseAttributeService;

    public LoginController(UserService userService, UserDetailsService userDetailsService, BaseAttributeService baseAttributeService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.baseAttributeService = baseAttributeService;
    }

    @GetMapping("/")
    public String loginpage(Model model) {
        model.addAttribute("error", null);
        return "layout/login";
    }

    @GetMapping("/loginsuccess")
    public String loginsuccess(Model model,HttpSession session) {
        model.addAttribute("userId",session.getAttribute("userId"));
        model.addAttribute("role",session.getAttribute("role"));
        return "layout/loginsuccess";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String accountId,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) { // Add HttpSession parameter

        // Validate user credentials via service
        User user = userService.findByAccountId(accountId);

        // Debug: Log the username entered
        System.out.println("Attempting to log in user: " + accountId);

        if (user == null || !user.getAccountPassword().equals(password)) {
            // If user is not found or password doesn't match
            model.addAttribute("error", "Invalid username or password");
            System.out.println("Login failed for user: " + accountId); // Debug statement
            return "layout/login";  // Return to the login page with an error message
        }

        // Retrieve user details and role
        UserDetails userDetails = userDetailsService.findByPartyId(user.getPartyId());
        String basePartyAttribute = baseAttributeService.findAttributeNameByPartyId(user.getPartyId());

        // Add user information to session
        session.setAttribute("userId", user.getPartyId());
        session.setAttribute("usernameKanji", userDetails.getPartyNameKj());
        session.setAttribute("usernameKana", userDetails.getPartyNameKn());
        session.setAttribute("userNameEn", userDetails.getPartyNameEn());
        session.setAttribute("role", basePartyAttribute);

        // Debug: Log the session attributes
        System.out.println("Session attributes set:");
        System.out.println("userId: " + user.getPartyId());
        System.out.println("usernameKanji: " + userDetails.getPartyNameKj());
        System.out.println("usernameKana: " + userDetails.getPartyNameKn());
        System.out.println("userNameEn: " + userDetails.getPartyNameEn());
        System.out.println("role: " + basePartyAttribute);

        // Print return data (optional)
        Map<String, Object> returnData = new HashMap<>();
        returnData.put("userid", user.getPartyId());
        returnData.put("usernameKanji", userDetails.getPartyNameKj());
        returnData.put("usernameKana", userDetails.getPartyNameKn());
        returnData.put("userNameEn", userDetails.getPartyNameEn());
        returnData.put("Role", basePartyAttribute);
        System.out.println(returnData);

        // If credentials are valid, redirect to home page or dashboard
        return "redirect:/loginsuccess";
    }
}
