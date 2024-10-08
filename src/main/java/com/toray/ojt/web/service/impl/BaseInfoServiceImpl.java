package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.BaseInfoInsertDto;
import com.toray.ojt.web.dto.BaseInfoSearchDto;
import com.toray.ojt.web.dto.BaseInfoViewRoleInsertDto;
import com.toray.ojt.web.dto.BaseinfoViewRoleNameGetDto;
import com.toray.ojt.web.mapper.BaseInfoMapper;
import com.toray.ojt.web.service.BaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    private static final Logger logger = LoggerFactory.getLogger(BaseInfoServiceImpl.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    private final BaseInfoMapper baseInfoMapper;

    public BaseInfoServiceImpl(BaseInfoMapper baseInfoMapper) {
        this.baseInfoMapper = baseInfoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BaseInfoSearchDto> searchBaseInfo(BaseInfoSearchDto searchDto) {
        List<BaseInfoSearchDto> resultList = baseInfoMapper.searchBaseInfo(searchDto);
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BaseinfoViewRoleNameGetDto> getRoles() {
        return baseInfoMapper.fetchRoles();
    }

    @Override
    @Transactional
    public Long insertBaseInfo(BaseInfoInsertDto baseInfoInsertDto) {
        try {
            convertDates(baseInfoInsertDto);
            baseInfoMapper.insertBaseInfo(baseInfoInsertDto);
            return baseInfoInsertDto.getSeqInfo();
        } catch (ParseException e) {
            logger.error("Failed to parse date", e);
            throw new RuntimeException("Invalid date format. Please use dd-MM-yyyy", e);
        }
    }

    @Override
    @Transactional
    public void insertBaseInfoRole(BaseInfoViewRoleInsertDto roleInsertDto) {
        baseInfoMapper.insertBaseInfoRole(roleInsertDto);
    }

    private void convertDates(BaseInfoInsertDto dto) throws ParseException {
        if (dto.getBeginYmd() != null && !dto.getBeginYmd().trim().isEmpty()) {
            java.util.Date parsedBeginDate = DATE_FORMAT.parse(dto.getBeginYmd());
            dto.setBeginYmd(new Date(parsedBeginDate.getTime()).toString());
        }

        if (dto.getEndYmd() != null && !dto.getEndYmd().trim().isEmpty()) {
            java.util.Date parsedEndDate = DATE_FORMAT.parse(dto.getEndYmd());
            dto.setEndYmd(new Date(parsedEndDate.getTime()).toString());
        }
    }
}