package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.BaseInfoInsertDto;
import com.toray.ojt.web.dto.BaseInfoSearchDto;

import com.toray.ojt.web.dto.BaseInfoViewRoleInsertDto;
import com.toray.ojt.web.dto.BaseinfoViewRoleNameGetDto;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BaseInfoMapper {
    // Search based on the BaseInfoSearchDto criteria
    List<BaseInfoSearchDto> searchBaseInfo(BaseInfoSearchDto searchDto);

    List<BaseinfoViewRoleNameGetDto> fetchRoles();  // Fetch roles from base_info_view_role_name table

    // Insert into base_info
    void insertBaseInfo(BaseInfoInsertDto baseInfoInsertDto);

    // Insert into base_info_view_role
    void insertBaseInfoRole(BaseInfoViewRoleInsertDto baseInfoViewRoleInsertDto);
}


