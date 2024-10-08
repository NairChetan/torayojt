package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.BaseInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BaseInfoMapper {
    List<BaseInfoDTO> findBaseInfo();
}
