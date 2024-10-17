package com.toray.ojt.web.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseAttributeMapper {
    String findAtrributeNameByPartyId(String partyId);
}
