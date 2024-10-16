package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseInfoMapper {
    List<BaseInfoDTO> findBaseInfo();
    // Search based on the BaseInfoSearchDto criteria
    List<BaseInfoSearchDto> getBaseInfo();

//    List<BaseInfoSearchDto> searchBaseInfo(String beginYmd, String endYmd, String title, String text, String importantFlg);


    List<BaseInfoSearchDto> searchBaseInfoWithPagination(
            String beginYmd, String endYmd, String title, String text, String importantFlg, String subject,int offset, int limit);

    int countBaseInfoSearchResults(String beginYmd, String endYmd, String title, String text, String importantFlg,String subject);


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


    // Update base_info based on seq_info
    int updateBaseInfo(BaseInfoUpdateDto baseInfoUpdateDto);

    // Delete all roles related to seq_info from base_info_view_role
    int deleteBaseInfoRoles(@Param("seqInfo") Long seqInfo);


    // Insert a new role into base_info_view_role
    int insertBaseInfoRoleWithSeqInfo(BaseInfoViewRoleInsertDto roleInsertDto);



}
