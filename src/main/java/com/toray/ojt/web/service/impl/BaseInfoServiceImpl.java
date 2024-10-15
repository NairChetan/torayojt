package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.*;
import com.toray.ojt.web.entity.PaginatedResult;
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
    public List<BaseInfoSearchDto> getAllBaseInfo() {
        return baseInfoMapper.getBaseInfo();
    }

//    @Override
//    public List<BaseInfoSearchDto> searchBaseInfo(String beginYmd, String endYmd, String title, String text, String importantFlg) {
//        return   baseInfoMapper.searchBaseInfo(beginYmd, endYmd, title, text, importantFlg);
//
//
//    }


    @Override
    public PaginatedResult<BaseInfoSearchDto> searchBaseInfoWithPagination(
            String beginYmd, String endYmd, String title, String text, String importantFlg,String subject, int page, int size) {

        int offset = (page - 1) * size;

        // Fetch paginated result from mapper
        List<BaseInfoSearchDto> results = baseInfoMapper.searchBaseInfoWithPagination(
                beginYmd, endYmd, title, text, importantFlg,subject, offset, size);

        // Fetch total count for the query (to calculate total pages)
        int totalCount = baseInfoMapper.countBaseInfoSearchResults(beginYmd, endYmd, title, text, importantFlg,subject);

        // Return the paginated response
        return new PaginatedResult<>(results, page, size, totalCount);
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
    public List<BaseInfoDTO> getBaseInfo() {
        return baseInfoMapper.findBaseInfo();
    }


    @Override
    @Transactional
    public void insertBaseInfoRole(BaseInfoViewRoleInsertDto roleInsertDto) {
        baseInfoMapper.insertBaseInfoRole(roleInsertDto);
    }

    @Override
    public BaseInfoDetailsBasedOnSeqInfoDto getBaseInfoBySeqInfo(Long seqInfo) {
        return baseInfoMapper.getBaseInfoBySeqInfo(seqInfo);
    }

    @Override
    public List<BaseInfoRoleBasedOnSeqInfoDto> getRolesBySeqInfo(Long seqInfo) {
        return baseInfoMapper.getRolesBySeqInfo(seqInfo);
    }

    @Override
    public void deleteBaseInfoBySeqInfo(Long seqInfo) {
        baseInfoMapper.deleteBySeqInfo(seqInfo);
    }

    @Override
    public int updateBaseInfo(BaseInfoUpdateDto baseInfoUpdateDto) {
        try {
            convertDates(baseInfoUpdateDto);
            return baseInfoMapper.updateBaseInfo(baseInfoUpdateDto);
        } catch (ParseException e) {
            logger.error("Failed to parse date", e);
            throw new RuntimeException("Invalid date format. Please use dd-MM-yyyy", e);
        }

    }

    @Override
    public void deleteBaseInfoRoles(Long seqInfo) {
        baseInfoMapper.deleteBaseInfoRoles(seqInfo);
    }

    @Override
    public void insertBaseInfoRoleWithSeqInfo(BaseInfoViewRoleInsertDto roleInsertDto) {
        baseInfoMapper.insertBaseInfoRoleWithSeqInfo(roleInsertDto);
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

    private void convertDates(BaseInfoUpdateDto dto) throws ParseException {
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