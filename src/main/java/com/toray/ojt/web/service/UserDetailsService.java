package com.toray.ojt.web.service;

import com.toray.ojt.web.entity.UserDetails;

public interface UserDetailsService {
    UserDetails findUserNameByPartyId(String partyId);
}
