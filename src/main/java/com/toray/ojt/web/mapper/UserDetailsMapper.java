package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.UserDetailsForUserNameOnlyDto;
import com.toray.ojt.web.entity.UserDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailsMapper {
    UserDetails findUserNameByPartyId(String partyId);
    UserDetailsForUserNameOnlyDto findUserNameOnlyByPartyId(String partyId);
}
