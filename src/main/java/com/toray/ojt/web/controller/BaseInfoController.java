package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.*;
import com.toray.ojt.web.service.BaseInfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class BaseInfoController {
    private final BaseInfoService baseInfoService;

    public BaseInfoController(BaseInfoService baseInfoService) {

        this.baseInfoService = baseInfoService;
    }

    @GetMapping("/search")
    public String getGuideList(Model model) {
        List<BaseInfoSearchDto> resultList = baseInfoService.getAllBaseInfo();
        model.addAttribute("baseInfos", resultList);
        return "layout/noticesearch";
    }
    // To fetch filtered guide data
    @GetMapping("/list")
    @ResponseBody
    public List<BaseInfoSearchDto> getSearchBaseInfo(
            @RequestParam(required = false) String beginYmd,
            @RequestParam(required = false) String endYmd,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String importantFlg
    ) {


        return baseInfoService.searchBaseInfo(beginYmd, endYmd, title, text, importantFlg);
    }

// to get the roles in the openlist
    @GetMapping("/roles")
    public ResponseEntity<List<BaseinfoViewRoleNameGetDto>> getRoles() {
        List<BaseinfoViewRoleNameGetDto> roles = baseInfoService.getRoles();
        return ResponseEntity.ok(roles);
    }


    // Add this method to handle the GET request and load the form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Add any necessary attributes to the model if needed
        return "layout/noticeinsert"; // This should match the Thymeleaf template you want to display
    }

    @PostMapping("/register")
    public String registerBaseInfo(@ModelAttribute BaseInfoInsertDto baseInfoInsertDto,
                                   @RequestParam List<String> roles, // Getting checked roles from the form
                                   Model model) {

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

        // Redirect to some view, perhaps the same form page or a confirmation page
        return "layout/noticeinsert"; // Change to the actual form page or success page
    }


    @GetMapping("/noticeDetail/{seqInfo}")
    public String getNoticeDetail(@PathVariable Long seqInfo, Model model) {
        BaseInfoDetailsBasedOnSeqInfoDto notice = baseInfoService.getBaseInfoBySeqInfo(seqInfo);
        System.out.println(notice.getSeqInfo());
        model.addAttribute("notice", notice);
        return "layout/noticeDetails";  // The Thymeleaf view name
    }


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

    @DeleteMapping("/{seqInfo}")
    public ResponseEntity<Void> deleteBaseInfo(@PathVariable Long seqInfo) {
        baseInfoService.deleteBaseInfoBySeqInfo(seqInfo);
        return ResponseEntity.noContent().build(); // 204 No Content
    }



    // Add this method to handle the GET request and load the form
    @GetMapping("/noticeUpdate/{seqInfo}")
    public String showUpdateForm(@PathVariable("seqInfo") Long seqInfo, Model model) {
        BaseInfoDetailsBasedOnSeqInfoDto notice= baseInfoService.getBaseInfoBySeqInfo(seqInfo);// Assuming service gets the data
        model.addAttribute("baseInfoUpdateDto", notice);
        System.out.println("ee:");
        System.out.println(notice.getSeqInfo());
        return "layout/noticeupdate";
    }


    // New PUT mapping for updating base info and roles
    @PutMapping("/noticeUpdate/{seqInfo}")
    public ResponseEntity<String> updateBaseInfo(@PathVariable("seqInfo") Long seqInfo,
                                                 @ModelAttribute BaseInfoUpdateDto baseInfoUpdateDto,
                                                 @RequestParam List<String> roles) {

        // Step 1: Set the seqInfo in the DTO
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

            // Return success message
            return ResponseEntity.ok("Base info and roles updated successfully");
        } else {
            // Handle case where base info could not be found or updated
            return ResponseEntity.status(404).body("Base info not found");
        }
    }
}
