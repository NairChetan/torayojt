package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.mapper.BaseAttributeMapper;
import com.toray.ojt.web.service.BaseAttributeService;
import org.springframework.stereotype.Service;

@Service
public class BaseAttributeServiceImpl implements BaseAttributeService {
    private final BaseAttributeMapper baseAttributeMapper;

    public BaseAttributeServiceImpl(BaseAttributeMapper baseAttributeMapper){
        this.baseAttributeMapper = baseAttributeMapper;
    }
    @Override
    public String findAttributeNameByPartyId(String partyId) {
        return baseAttributeMapper.findAtrributeNameByPartyId(partyId);
    }
}
