package com.toray.ojt.web.service.impl;
import com.toray.ojt.web.entity.BasePartyAttribute;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.BaseAttributeMapper;
import com.toray.ojt.web.mapper.UserDetailsMapper;
import com.toray.ojt.web.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserMapper userMapper;
    private final BaseAttributeMapper baseAttributeMapper;
    private final UserDetailsMapper userDetailsMapper;

    public CustomUserDetailsService(UserMapper userMapper,BaseAttributeMapper baseAttributeMapper,UserDetailsMapper userDetailsMapper){
        this.userMapper = userMapper;
        this.baseAttributeMapper = baseAttributeMapper;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByAccountId(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with Account ID: " + username);
        }

        String role = baseAttributeMapper.findAtrributeNameByPartyId(user.getPartyId());

        com.toray.ojt.web.entity.UserDetails userDetails = userDetailsMapper.findUserNameByPartyId(user.getPartyId());
        if (userDetails == null) {
            throw new UsernameNotFoundException("User details not found with user ID: " + user.getPartyId());
        }

        return new org.springframework.security.core.userdetails.User(
                user.getAccountId(),
                user.getPartyId(),
                userDetails.getPartyNameEn(),
                userDetails.getPartyNameKj(),
                userDetails.getPartyNameKn(),
                getAuthorities(role)
        );
        private Collection<? extends GrantedAuthority> getAuthorities(String role) {
            // Assuming roles are represented as a single authority
            return Collections.singletonList(new SimpleGrantedAuthority(role));
      }

}
}
