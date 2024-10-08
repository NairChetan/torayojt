package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.TGuideDTO;
import com.toray.ojt.web.mapper.TGuideMapper;
import com.toray.ojt.web.service.TGuideService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TGuideServiceImpl implements TGuideService {

    private final TGuideMapper tGuideMapper;

    public TGuideServiceImpl(TGuideMapper tGuideMapper) {
        this.tGuideMapper = tGuideMapper;
    }

    @Override
    public List<TGuideDTO> getTGuide() {
        return tGuideMapper.findTGuide();
    }
}
