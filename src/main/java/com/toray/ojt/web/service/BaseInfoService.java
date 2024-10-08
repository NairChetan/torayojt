package com.toray.ojt.web.service;

import com.toray.ojt.web.dto.BaseInfoInsertDto;
import com.toray.ojt.web.dto.BaseInfoViewRoleInsertDto;
import com.toray.ojt.web.dto.BaseinfoViewRoleNameGetDto;
import com.toray.ojt.web.entity.BaseInfo;
import com.toray.ojt.web.dto.BaseInfoSearchDto;
import com.toray.ojt.web.dto.BaseInfoDTO;

import java.util.List;

public interface BaseInfoService {
    List<BaseInfoDTO> getBaseInfo();
    List<BaseInfoSearchDto> searchBaseInfo(BaseInfoSearchDto searchDto);

    List<BaseinfoViewRoleNameGetDto> getRoles();  // Fetch roles from base_info_view_role_name

    Long insertBaseInfo(BaseInfoInsertDto baseInfoInsertDto); // Insert into base_info
    void insertBaseInfoRole(BaseInfoViewRoleInsertDto roleInsertDto); // Insert into base_info_view_role
}
