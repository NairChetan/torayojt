package com.toray.ojt.web.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String partyId;
    private final String partyNameEn;
    private final String partyNameKj;
    private final String partyNameKn;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             String partyId, String partyNameEn, String partyNameKj, String partyNameKn) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.partyId = partyId;
        this.partyNameEn = partyNameEn;
        this.partyNameKj = partyNameKj;
        this.partyNameKn = partyNameKn;
    }

    public String getPartyId() {
        return partyId;
    }

    public String getPartyNameEn() {
        return partyNameEn;
    }

    public String getPartyNameKj() {
        return partyNameKj;
    }

    public String getPartyNameKn() {
        return partyNameKn;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // Return the actual authorities
    }

    @Override
    public String getPassword() {
        return password; // Return the actual password
    }

    @Override
    public String getUsername() {
        return username; // Return the actual username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Typically true for non-expired accounts
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Typically true for non-locked accounts
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Typically true for non-expired credentials
    }

    @Override
    public boolean isEnabled() {
        return true; // Typically true for enabled accounts
    }
}
