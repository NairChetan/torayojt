package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.*;
import com.toray.ojt.web.entity.CustomUserDetails;
import com.toray.ojt.web.entity.PaginatedResult;
import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.UserMapper;
import com.toray.ojt.web.service.BaseInfoService;
import com.toray.ojt.web.service.UserDetailsService;
import com.toray.ojt.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@Validated
public class BaseInfoController {
    private static final Logger logger = LoggerFactory.getLogger(BaseInfoController.class);
    private final BaseInfoService baseInfoService;
    private final UserDetailsService userDetailsService;

    public BaseInfoController(BaseInfoService baseInfoService,UserDetailsService userDetailsService) {

        this.baseInfoService = baseInfoService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Handles GET requests to fetch the list of base information and displays it in the noticesearch view.
     *
     * @param model a container object for passing data to the Thymeleaf view
     * @return the name of the Thymeleaf template to be rendered (i.e., "layout/noticesearch")
     */
    @GetMapping("/search")
    public String getGuideList(Model model) {
        logger.info("Fetching notices ...");
        List<BaseInfoSearchDto> resultList = baseInfoService.getAllBaseInfo();
        logger.debug("Fetched {} base info records", resultList.size());
        List<NoticeSearchResultDto> modelList = new ArrayList<>();
        logger.info("Fetching user who updated notices...");
//        List<UserDetailsForUserNameOnlyDto> nameList = new ArrayList<>();
        for(BaseInfoSearchDto baseInfoSearchDto:resultList) {
            logger.debug("Fetching user name for updUserId: {}", baseInfoSearchDto.getUpdUserId());
            UserDetailsForUserNameOnlyDto userDetails = userDetailsService.findUserNameOnly(baseInfoSearchDto.getUpdUserId());
            NoticeSearchResultDto noticeSearchResultDto = new NoticeSearchResultDto();
            noticeSearchResultDto.setImportantFlg(baseInfoSearchDto.getImportantFlg());
            noticeSearchResultDto.setTitle(baseInfoSearchDto.getTitle());
            noticeSearchResultDto.setText(baseInfoSearchDto.getText());
            noticeSearchResultDto.setBeginYmd(baseInfoSearchDto.getBeginYmd());
            noticeSearchResultDto.setEndYmd(baseInfoSearchDto.getEndYmd());
            noticeSearchResultDto.setUpdTimestamp(baseInfoSearchDto.getUpdTimestamp());
            noticeSearchResultDto.setSeqInfo(baseInfoSearchDto.getSeqInfo());
            noticeSearchResultDto.setUpdUserId(baseInfoSearchDto.getUpdUserId());
            noticeSearchResultDto.setPartyId(userDetails.getPartyId());
            noticeSearchResultDto.setPartyNameKj(userDetails.getPartyNameKj());
            noticeSearchResultDto.setPartyNameEn(userDetails.getPartyNameEn());
            noticeSearchResultDto.setPartyNameKn(userDetails.getPartyNameKn());
            modelList.add(noticeSearchResultDto);
        }
        model.addAttribute("baseInfos", modelList);
        return "layout/noticesearch";
    }
    // To fetch filtered guide data
//    @GetMapping("/list")
//    @ResponseBody
//    public List<BaseInfoSearchDto> getSearchBaseInfo(
//            @RequestParam(required = false) String beginYmd,
//            @RequestParam(required = false) String endYmd,
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String text,
//            @RequestParam(required = false) String importantFlg
//    ) {
//
//
//        return baseInfoService.searchBaseInfo(beginYmd, endYmd, title, text, importantFlg);
//    }

    /**
     * Handles GET requests to search for base info with optional filtering parameters
     * and pagination options. Returns a paginated list of BaseInfoSearchDto objects.
     *
     * @param beginYmd       optional beginning date for filtering (format: YYYY-MM-DD)
     * @param endYmd         optional ending date for filtering (format: YYYY-MM-DD)
     * @param title          optional title for filtering
     * @param text           optional text content for filtering
     * @param importantFlg   optional flag to filter important records (Y/N)
     * @param subject        optional roles for filtering
     * @param page           the page number to retrieve, defaults to 1
     * @param size           the number of items per page, defaults to 6
     * @return a paginated result of BaseInfoSearchDto containing the filtered and paginated base info
     */
    @GetMapping("/list")
    @ResponseBody
    public PaginatedResult<BaseInfoSearchDto> getSearchBaseInfo(
            @RequestParam(required = false) String beginYmd,
            @RequestParam(required = false) String endYmd,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String importantFlg,
            @RequestParam(required = false) String subject,
            @RequestParam(defaultValue = "1") int page,   // Page number, default 1
            @RequestParam(defaultValue = "6") int size   // Page size, default 10
    ) {
        return baseInfoService.searchBaseInfoWithPagination(beginYmd, endYmd, title, text, importantFlg,subject, page, size);
    }




    /**
     * Handles GET requests to retrieve a list of roles.
     * The roles are returned in the form of a list of BaseinfoViewRoleNameGetDto objects.
     *
     * @return a ResponseEntity containing a list of roles (BaseinfoViewRoleNameGetDto) and an HTTP status of 200 (OK)
     */
    @GetMapping("/roles")
    public ResponseEntity<List<BaseinfoViewRoleNameGetDto>> getRoles() {
        List<BaseinfoViewRoleNameGetDto> roles = baseInfoService.getRoles();
        return ResponseEntity.ok(roles);
    }


    /**
     * Handles GET requests to display the registration form.
     * Returns the view for rendering the form.
     *
     * @param model the model used to pass attributes to the view
     * @return the name of the Thymeleaf template for the registration form (i.e., "layout/noticeinsert")
     */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Add any necessary attributes to the model if needed
        return "layout/noticeinsert"; // This should match the Thymeleaf template you want to display
    }


    /**
     * Handles POST requests to register new base info and map the selected roles.
     * The base info is inserted into the `base_info` table, and the selected roles are mapped
     * to the `base_info_view_role` table using the generated `seqInfo` and the selected roles.
     *
     * @param baseInfoInsertDto the DTO containing the base information form data, which is validated
     * @param roles the list of selected roles from the form, used to map roles to the `base_info_view_role` table
     * @param model the model used to pass attributes (e.g., success messages) to the view
     * @return the view name (Thymeleaf template) to render after successful registration
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerBaseInfo( @Valid @RequestBody @ModelAttribute BaseInfoInsertDto baseInfoInsertDto,
                                   @RequestParam List<String> roles, // Getting checked roles from the form
                                   Model model, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String partyId = userDetails.getPartyId();
        baseInfoInsertDto.setCrtUserId(partyId);
        baseInfoInsertDto.setUpdUserId(partyId);
        // Step 1: Insert base info into `base_info` table
        Long seqInfo = baseInfoService.insertBaseInfo(baseInfoInsertDto);
         System.out.println(seqInfo);

        // Step 2: Map roles to the `base_info_view_role` table using the inserted `seqInfo`
        for (String role : roles) {
            BaseInfoViewRoleInsertDto roleInsertDto = new BaseInfoViewRoleInsertDto();
            roleInsertDto.setSeqInfo(seqInfo);
            roleInsertDto.setRole(role);
            baseInfoService.insertBaseInfoRole(roleInsertDto);
        }

        // Optionally, you can add success messages or handle any validation issues here
        model.addAttribute("message", "Content registered successfully!");

        // Redirect to noticeDetail page for the updated seqInfo
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/noticeDetail/" + seqInfo));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

    /**
     * Handles GET requests to retrieve the details of a notice based on its sequence info.
     * The details are fetched from the service layer and passed to the Thymeleaf view.
     *
     * @param seqInfo the unique identifier for the notice, extracted from the URL path
     * @param model the model used to pass the notice details to the view
     * @return the name of the Thymeleaf template for displaying the notice details (i.e., "layout/noticeDetails")
     */
    @GetMapping("/noticeDetail/{seqInfo}")
    public String getNoticeDetail(@PathVariable Long seqInfo, Model model) {
        BaseInfoDetailsBasedOnSeqInfoDto notice = baseInfoService.getBaseInfoBySeqInfo(seqInfo);
        System.out.println(notice.getSeqInfo());
        UserDetailsForUserNameOnlyDto userDetailsForUserNameOnlyDto = userDetailsService.findUserNameOnly(notice.getCrtUserId());
        notice.setPartyName(userDetailsForUserNameOnlyDto.getPartyNameEn());
        model.addAttribute("notice", notice);
        return "layout/noticeDetails";  // The Thymeleaf view name
    }

    /**
     * Handles GET requests to retrieve the list of role names associated with a specific notice
     * identified by its seqInfo.
     *
     * @param seqInfo the unique identifier for the notice, extracted from the URL path
     * @return a ResponseEntity containing a list of role names (Strings) associated with the notice,
     *         along with an HTTP status of 200 OK
     */
    @GetMapping("/noticeDetail/roles/{seqInfo}")
    public ResponseEntity<List<String>> getRolesBySeqInfo(@PathVariable Long seqInfo) {
        // Fetch the list of DTOs from the service
        List<BaseInfoRoleBasedOnSeqInfoDto> roleDtos = baseInfoService.getRolesBySeqInfo(seqInfo);

        // Map the DTOs to extract only the role names (Strings)
        List<String> roles = roleDtos.stream()
                .map(BaseInfoRoleBasedOnSeqInfoDto::getRole) // Assuming getRole() returns the role name as String
                .collect(Collectors.toList());

        return ResponseEntity.ok(roles); // Return the list of role names
    }


    /**
     * Handles DELETE requests to remove a specific base information entry identified by its sequence info.
     *
     * @param seqInfo the unique identifier for the base information entry, extracted from the URL path
     * @return a ResponseEntity with a status of 204 No Content indicating successful deletion
     */
    @DeleteMapping("/{seqInfo}")
    public ResponseEntity<Void> deleteBaseInfo(@PathVariable Long seqInfo) {
        baseInfoService.deleteBaseInfoBySeqInfo(seqInfo);
        return ResponseEntity.noContent().build(); // 204 No Content
    }



    /**
     * Handles GET requests to load the update form for a specific notice identified by its seqInfo.
     *
     * @param seqInfo the unique identifier for the notice, extracted from the URL path
     * @param model the model to hold attributes for the view
     * @return the name of the Thymeleaf template for the update form
     */
    @GetMapping("/noticeUpdate/{seqInfo}")
    public String showUpdateForm(@PathVariable("seqInfo") Long seqInfo, Model model) {
        BaseInfoDetailsBasedOnSeqInfoDto notice= baseInfoService.getBaseInfoBySeqInfo(seqInfo);
        UserDetailsForUserNameOnlyDto userDetailsForUserNameOnlyDto = userDetailsService.findUserNameOnly(notice.getCrtUserId());
        notice.setPartyName(userDetailsForUserNameOnlyDto.getPartyNameEn());
        model.addAttribute("baseInfoUpdateDto", notice);
        System.out.println("ee:");
        System.out.println(notice.getSeqInfo());
        return "layout/noticeupdate";
    }


    /**
     * Handles PUT requests to update the base information and roles for a specific notice identified by its sequence info.
     *
     * @param seqInfo           the unique identifier for the notice, extracted from the URL path
     * @param baseInfoUpdateDto the DTO containing updated base information
     * @param roles             the list of roles to be associated with the notice
     * @return the name of the Thymeleaf template to redirect to after the update
     */
    @PutMapping("/noticeUpdate/{seqInfo}")
    public ResponseEntity<String> updateBaseInfo(@Valid @RequestBody @PathVariable("seqInfo") Long seqInfo,
                                                 @ModelAttribute BaseInfoUpdateDto baseInfoUpdateDto,
                                                 @RequestParam List<String> roles,Authentication authentication) {

        // Step 1: Set the seqInfo in the DTO
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String partyId=userDetails.getPartyId();
        baseInfoUpdateDto.setUpdUserId(partyId);
        baseInfoUpdateDto.setSeqInfo(seqInfo);

        System.out.println("ee:");
        System.out.println(baseInfoUpdateDto.getSeqInfo());

        // Step 2: Update the base_info table
        int updatedRows = baseInfoService.updateBaseInfo(baseInfoUpdateDto);

        if (updatedRows > 0) {
            // Step 3: Delete existing roles for the given seqInfo
            baseInfoService.deleteBaseInfoRoles(seqInfo);

            // Step 4: Insert new roles into the base_info_view_role table
            for (String role : roles) {
                BaseInfoViewRoleInsertDto roleInsertDto = new BaseInfoViewRoleInsertDto();
                roleInsertDto.setSeqInfo(seqInfo);
                roleInsertDto.setRole(role);
                baseInfoService.insertBaseInfoRoleWithSeqInfo(roleInsertDto);
            }

            // Redirect to noticeDetail page for the updated seqInfo
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/noticeDetail/" + seqInfo));

            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
//         return "layout/noticeDetails";
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while updating base info and roles.");
        }
    }
}
