package com.toray.ojt.web.service;

import com.toray.ojt.web.dto.*;
import com.toray.ojt.web.entity.BaseInfo;


import java.util.List;

public interface BaseInfoService {
    List<BaseInfoDTO> getBaseInfo();
    List<BaseInfoSearchDto> searchBaseInfo(BaseInfoSearchDto searchDto);

    List<BaseinfoViewRoleNameGetDto> getRoles();  // Fetch roles from base_info_view_role_name

    Long insertBaseInfo(BaseInfoInsertDto baseInfoInsertDto); // Insert into base_info
    void insertBaseInfoRole(BaseInfoViewRoleInsertDto roleInsertDto); // Insert into base_info_view_role

    BaseInfoDetailsBasedOnSeqInfoDto getBaseInfoBySeqInfo(Long seqInfo);

    List<BaseInfoRoleBasedOnSeqInfoDto> getRolesBySeqInfo(Long seqInfo);

    void deleteBaseInfoBySeqInfo(Long seqInfo);

}
