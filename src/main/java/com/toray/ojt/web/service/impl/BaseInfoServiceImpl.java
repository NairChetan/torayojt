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


    /**
     *Retrieves all base info records from the database.
     *
     * This method invokes the baseInfoMapper's getBaseInfo() method
     * to fetch a list of BaseInfoSearchDto objects, which represent
     * the data transfer objects for base information. The returned
     * list contains all records without any filtering or pagination.
     *
     * @return List<BaseInfoSearchDto> a list of BaseInfoSearchDto objects representing
     *         all base information records in the database. Returns an empty list
     *         if no records are found.
     */
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



    /**
     * Searches for base information records with pagination based on the provided criteria.
     *
     * This method allows clients to filter and paginate the search results for base information.
     * It calculates the offset for the query based on the current page number and size.
     * The method retrieves both the paginated results and the total count of matching records
     * to facilitate proper pagination on the client side.
     *
     * @param beginYmd      the start date for filtering results (inclusive), in the format YYYY-MM-DD.
     * @param endYmd        the end date for filtering results (inclusive), in the format YYYY-MM-DD.
     * @param title         the title to filter results by; can be null or empty to include all titles.
     * @param text          the text to search for in the base information; can be null or empty to include all.
     * @param importantFlg  flag indicating whether to filter by importance; can be null to include all.
     * @param subject       the subject to filter results by; can be null or empty to include all subjects.
     * @param page          the current page number to retrieve, starting from 1.
     * @param size          the number of records to retrieve per page.
     *
     * @return PaginatedResult<BaseInfoSearchDto> a paginated result containing a list of
     *         BaseInfoSearchDto objects for the current page, along with pagination metadata:
     *         - The current page number.
     *         - The size of the page.
     *         - The total count of matching records.
     */
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



    /**
     * Retrieves a list of roles from the database.
     *
     * This method is responsible for fetching all available roles from the `base_info_view_role` table.
     * It is annotated with @Transactional(readOnly = true) to indicate that it only reads data
     * and does not modify any records, which helps in optimizing performance and ensuring
     * consistency during data retrieval.
     *
     * @return List<BaseinfoViewRoleNameGetDto> a list of BaseinfoViewRoleNameGetDto objects,
     *         each representing a role name and associated data retrieved from the database.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BaseinfoViewRoleNameGetDto> getRoles() {
        return baseInfoMapper.fetchRoles();
    }


    /**
     * Inserts a new base information record into the database.
     *
     * This method takes a BaseInfoInsertDto object, converts its date fields to the required format,
     * and then inserts the data into the `base_info` table via the baseInfoMapper. If the date conversion fails,
     * a RuntimeException is thrown with an appropriate error message.
     *
     * @param baseInfoInsertDto the data transfer object containing the information to be inserted
     * @return Long the sequence information (seqInfo) of the newly inserted record,
     *              as provided by the BaseInfoInsertDto after insertion
     * @throws RuntimeException if there is an error parsing the date fields within the provided DTO.
     */
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



    /**
     * Inserts a new role associated with a base information record into the database.
     *
     * This method takes a BaseInfoViewRoleInsertDto object, which contains the information
     * about the role to be associated with a base information entry. The method calls the
     * baseInfoMapper to perform the actual insertion into the `base_info_view_role` table.
     *
     * @param roleInsertDto the data transfer object containing the role information to be inserted
     */
    @Override
    @Transactional
    public void insertBaseInfoRole(BaseInfoViewRoleInsertDto roleInsertDto) {
        baseInfoMapper.insertBaseInfoRole(roleInsertDto);
    }


    /**
     * Retrieves detailed base information based on the provided sequence information ID.
     *
     * This method queries the database to fetch the details of a specific base information
     * record identified by its unique sequence ID (seqInfo). It calls the baseInfoMapper
     * to execute the query and return the corresponding data transfer object.
     *
     * @param seqInfo the unique identifier of the base information record to be retrieved
     * @return BaseInfoDetailsBasedOnSeqInfoDto containing the details of the specified base information,
     *         or null if no record is found for the provided ID
     */
    @Override
    public BaseInfoDetailsBasedOnSeqInfoDto getBaseInfoBySeqInfo(Long seqInfo) {
        return baseInfoMapper.getBaseInfoBySeqInfo(seqInfo);
    }



    /**
     * Retrieves a list of roles associated with the specified sequence information ID.
     *
     * This method queries the database to fetch all roles that are linked to a
     * specific base information record identified by its unique sequence ID (seqInfo).
     * It utilizes the baseInfoMapper to execute the query and return the corresponding
     * list of role data transfer objects.
     *
     * @param seqInfo the unique identifier of the base information record for which roles are to be retrieved
     * @return a List of BaseInfoRoleBasedOnSeqInfoDto containing the roles associated with the specified base information,
     *         or an empty list if no roles are found for the provided ID
     */
    @Override
    public List<BaseInfoRoleBasedOnSeqInfoDto> getRolesBySeqInfo(Long seqInfo) {
        return baseInfoMapper.getRolesBySeqInfo(seqInfo);
    }


    /**
     * Deletes the base information record associated with the specified sequence information ID.
     *
     * This method calls the baseInfoMapper to execute the deletion operation for
     * the base information record identified by the provided seqInfo. It removes
     * the record from the database, ensuring that any associated data (if applicable)
     * is also handled appropriately according to the database's foreign key constraints.
     *
     * @param seqInfo the unique identifier of the base information record to be deleted
     * @throws  if there is an issue accessing the database during the deletion
     */
    @Override
    public void deleteBaseInfoBySeqInfo(Long seqInfo) {
        baseInfoMapper.deleteBySeqInfo(seqInfo);
    }

    /**
     * Updates the base information record with the specified details.
     *
     * This method converts the date fields in the provided BaseInfoUpdateDto to the
     * appropriate format and then calls the baseInfoMapper to update the record in
     * the database. If the date format is invalid, it logs an error and throws a
     * RuntimeException with a descriptive message.
     *
     * @param baseInfoUpdateDto the DTO containing the updated base information details
     * @return int the number of records updated in the database (should be 1 if successful)
     * @throws RuntimeException if there is a date parsing error, indicating an invalid date format
     */
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
    /**
     * Deletes all role entries associated with a given base information record.
     *
     * This method calls the baseInfoMapper to remove all roles linked to the
     * specified seqInfo. It is typically used when updating or deleting a base
     * information record to ensure that any related roles are also removed.
     *
     * @param seqInfo the unique identifier for the base information record
     *                whose roles are to be deleted
     */
    @Override
    public void deleteBaseInfoRoles(Long seqInfo) {
        baseInfoMapper.deleteBaseInfoRoles(seqInfo);
    }


    /**
     * Inserts a new role entry into the base_info_view_role table with the specified seqInfo.
     *
     * This method utilizes the baseInfoMapper to persist the role information
     * associated with a specific base information record. It is commonly used
     * when assigning roles to a base information record during creation or
     * update operations.
     *
     * @param roleInsertDto the Data Transfer Object (DTO) containing the role
     *                      information and the associated seqInfo to be inserted
     */
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