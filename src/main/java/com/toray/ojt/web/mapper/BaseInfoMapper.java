package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BaseInfoMapper {
    List<BaseInfoDTO> findBaseInfo();
    // Search based on the BaseInfoSearchDto criteria
    List<BaseInfoSearchDto> searchBaseInfo(BaseInfoSearchDto searchDto);

    List<BaseinfoViewRoleNameGetDto> fetchRoles();  // Fetch roles from base_info_view_role_name table

    // Insert into base_info
    void insertBaseInfo(BaseInfoInsertDto baseInfoInsertDto);

    // Insert into base_info_view_role
    void insertBaseInfoRole(BaseInfoViewRoleInsertDto baseInfoViewRoleInsertDto);

    //Fecth notice details based on seqInfo
    BaseInfoDetailsBasedOnSeqInfoDto getBaseInfoBySeqInfo(@Param("seqInfo") Long seqInfo);

    //Fetch the roles based on seqInfo
    List<BaseInfoRoleBasedOnSeqInfoDto> getRolesBySeqInfo(Long seqInfo);

    void deleteBySeqInfo(Long seqInfo);

    //Update
    int updateNotice(@Param("baseInfo") BaseInfoUpdateDto baseInfo);

    BaseInfoUpdateDto getNoticeBySeqInfo(Long seqInfo);

}
