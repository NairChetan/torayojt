package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.TGuideDTO;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.entity.UserDetails;
import com.toray.ojt.web.service.BaseAttributeService;
import com.toray.ojt.web.service.TGuideService;
import com.toray.ojt.web.service.UserDetailsService;
import com.toray.ojt.web.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final BaseAttributeService baseAttributeService;
    private final TGuideService tGuideService;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UserService userService, UserDetailsService userDetailsService, BaseAttributeService baseAttributeService, TGuideService tGuideService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.baseAttributeService = baseAttributeService;
        this.tGuideService = tGuideService;
    }

    @GetMapping("/")
    public String loginpage(@RequestParam(value="error",required = false) String error,@RequestParam(value="logout",required = false) String logout, Model model) {
        if(error!=null)
        {model.addAttribute("errorMessage",error);}
        return "layout/login";
    }

    @GetMapping("/RegularUser")
    public String loginsuccess(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Current Auth: " + auth); // Log current authentication
        List<TGuideDTO> tGuideDTOList = tGuideService.getTGuide();
        model.addAttribute("guides",tGuideDTOList);
        return "layout/RegularUser";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam("username") String accountId,
//                        @RequestParam("password") String password,
//                        Model model,
//                        HttpSession session) { // Add HttpSession parameter
//
//        // Validate user credentials via service
//        User user = userService.findByAccountId(accountId);
//
//        // Debug: Log the username entered
//        System.out.println("Attempting to log in user: " + accountId);
//
//        if (user == null || !user.getAccountPassword().equals(password)) {
//            // If user is not found or password doesn't match
//            model.addAttribute("error", "Invalid username or password");
//            System.out.println("Login failed for user: " + accountId); // Debug statement
//            return "layout/login";  // Return to the login page with an error message
//        }
//
//        // Retrieve user details and role
//        UserDetails userDetails = userDetailsService.findUserNameByPartyId(user.getPartyId());
//        log.debug("UserDetails: {}", userDetails);
//        String basePartyAttribute = baseAttributeService.findAttributeNameByPartyId(user.getPartyId());
//        System.out.println(basePartyAttribute);
//
//        // Add user information to session
//        session.setAttribute("userId", user.getPartyId());
//        session.setAttribute("usernameKanji", userDetails.getPartyNameKj());
//        session.setAttribute("usernameKana", userDetails.getPartyNameKn());
//        session.setAttribute("userNameEn", userDetails.getPartyNameEn());
//        session.setAttribute("role", basePartyAttribute);
//
//        // Debug: Log the session attributes
//        System.out.println("Session attributes set:");
//        System.out.println("userId: " + user.getPartyId());
//        System.out.println("usernameKanji: " + userDetails.getPartyNameKj());
//        System.out.println("usernameKana: " + userDetails.getPartyNameKn());
//        System.out.println("userNameEn: " + userDetails.getPartyNameEn());
//        System.out.println("role: " + basePartyAttribute);
//
//        // Print return data (optional)
//        Map<String, Object> returnData = new HashMap<>();
//        returnData.put("userid", user.getPartyId());
//        returnData.put("usernameKanji", userDetails.getPartyNameKj());
//        returnData.put("usernameKana", userDetails.getPartyNameKn());
//        returnData.put("userNameEn", userDetails.getPartyNameEn());
//        returnData.put("Role", basePartyAttribute);
//        System.out.println(returnData);
//        if(basePartyAttribute.equalsIgnoreCase("base_admin")) {
//            return "redirect:/toppage";
//        }
//        return "redirect:/loginsuccess";
//    }
}
