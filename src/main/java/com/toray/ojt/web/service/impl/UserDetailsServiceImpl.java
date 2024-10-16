package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.UserDetailsForUserNameOnlyDto;
import com.toray.ojt.web.entity.UserDetails;
import com.toray.ojt.web.mapper.UserDetailsMapper;
import com.toray.ojt.web.service.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsMapper userDetailsMapper;

    public UserDetailsServiceImpl(UserDetailsMapper userDetailsMapper) {
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails findUserNameByPartyId(String partyId) {
        UserDetails userDetails = userDetailsMapper.findUserNameByPartyId(partyId);
        return userDetails;
    }

    @Override
    public UserDetailsForUserNameOnlyDto findUserNameOnly(String partyId) {
        UserDetailsForUserNameOnlyDto userDetailsForUserNameOnlyDto = userDetailsMapper.findUserNameOnlyByPartyId(partyId);
        return userDetailsForUserNameOnlyDto;
    }
}