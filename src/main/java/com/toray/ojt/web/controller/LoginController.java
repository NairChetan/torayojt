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
}
