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

    /**
     * Retrieves a list of BaseInfoDTO objects
     * This method calls the mapper to fetch data from the Base_info table.
     * @return A list of BaseInfoDTO containing the notice information.
     */
    @Override
    public List<BaseInfoDTO> getBaseInfo() {
        return baseInfoMapper.findBaseInfo();
    }
}
