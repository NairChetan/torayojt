package com.toray.ojt.web.service.impl;
import com.toray.ojt.web.entity.BasePartyAttribute;
import com.toray.ojt.web.entity.CustomUserDetails;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.BaseAttributeMapper;
import com.toray.ojt.web.mapper.UserDetailsMapper;
import com.toray.ojt.web.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;
    private final BaseAttributeMapper baseAttributeMapper;
    private final UserDetailsMapper userDetailsMapper;
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);


    public CustomUserDetailsService(UserMapper userMapper, BaseAttributeMapper baseAttributeMapper, UserDetailsMapper userDetailsMapper) {
        this.userMapper = userMapper;
        this.baseAttributeMapper = baseAttributeMapper;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user by accountId
        log.debug("Parameter username: {}", username);
        User user = userMapper.findByAccountId(username);
        log.debug("User Object: {}", user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with Account ID: " + username);
        }

        // Load user role based on partyId
        String role = baseAttributeMapper.findAtrributeNameByPartyId(user.getPartyId());
        log.debug("User role: {}", role);

        // Load user details (such as names)
        com.toray.ojt.web.entity.UserDetails userDetails = userDetailsMapper.findUserNameByPartyId(user.getPartyId());
        if (userDetails == null) {
            throw new UsernameNotFoundException("User details not found for user ID: " + user.getPartyId());
        }

        // Return the CustomUserDetails object
        return new CustomUserDetails(
                user.getAccountId(),
                user.getAccountPassword(),
                getAuthorities(role),// Get authorities based on role
                userDetails.getPartyId(),
                userDetails.getPartyNameEn(), // English name
                userDetails.getPartyNameKj(), // Kanji name
                userDetails.getPartyNameKn()  // Kana name
        );
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String role) {
        // Create a list of authorities based on the user's role
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Add the user's role as a GrantedAuthority
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }
}
