package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.BaseInfoDTO;
import com.toray.ojt.web.mapper.BaseInfoMapper;
import com.toray.ojt.web.service.BaseInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    private final BaseInfoMapper baseInfoMapper;

    public BaseInfoServiceImpl(BaseInfoMapper baseInfoMapper) {
        this.baseInfoMapper = baseInfoMapper;
    }

    @Override
    public List<BaseInfoDTO> getBaseInfo() {
        return baseInfoMapper.findBaseInfo();
    }
}
