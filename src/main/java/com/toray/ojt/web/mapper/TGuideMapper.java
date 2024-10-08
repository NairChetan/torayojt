package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.TGuideDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TGuideMapper {
    List<TGuideDTO> findTGuide();
}
